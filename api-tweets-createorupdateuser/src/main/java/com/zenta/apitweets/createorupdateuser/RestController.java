package com.zenta.apitweets.createorupdateuser;

import com.zenta.apitweets.business.pojo.User;
import com.zenta.apitweets.createorupdateuser.http.CheckUser;
import com.zenta.apitweets.createorupdateuser.http.CreateUser;
import com.zenta.apitweets.createorupdateuser.http.UpdateUser;
import com.zenta.apitweets.createorupdateuser.http.UserResponse;
import com.zenta.apitweets.business.utils.ReadFile;
import com.zenta.apitweets.createorupdateuser.http.ApiUsersResult;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Nb-Zenta
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/create-or-update-user")
public class RestController {
    
    private final Logger LOG = LoggerFactory.getLogger(RestController.class);
    
    private final RestTemplate restTemplate;
    
    private final String endpoint;
    
    @Value("classpath:request-check-user")
    private Resource requestCheckUser;
    @Value("classpath:request-create-user")
    private Resource requestCreateUser;
    @Value("classpath:request-update-user")
    private Resource requestUpdateUser;
    
    @Autowired
    public RestController(RestTemplate rt) {
        this.restTemplate = rt;
        String host = System.getenv("API_TWEETS_GRAPHQL_SERVICE_HOST");
        String port = System.getenv("API_TWEETS_GRAPHQL_SERVICE_PORT");
        LOG.info("host: " + host + ", port: " + port);
        this.endpoint = "http://"+host+ ":" + port+"/tweets";
        LOG.info("API endpoint: " + this.endpoint);
    }
    
 
    @PostMapping
    public ResponseEntity createOrUpdate(
            @RequestBody(required=false) String query,
            @RequestParam(value="id", required=false) String id, 
            @RequestParam(value="name",required=false) String name, 
            @RequestParam(value="profileUrl",required=false) String profileUrl, 
            @RequestParam(value="createdAt",required=false) String createdAt,
            @RequestParam(value="following", required=false) String following
        ) throws IOException {
        
        LOG.info("createOrUpdate  [id: " + id + ", name: " + name+ ", profileUrl: " + profileUrl+ ", createdAt: " + createdAt+"]");
        User user = null;
        try {
            user = checkUser(id,profileUrl);
        } catch (Exception e) {
            LOG.error("Error al invocar el servicio.", e);
        }     
        ApiUsersResult result = new ApiUsersResult();  
        
        String input = ReadFile.readFromInputStream(user==null?
                requestCreateUser.getInputStream():
                requestUpdateUser.getInputStream());
        input = input.replace("$name", name)
                .replace("$profileUrl", profileUrl)
                .replace("$createAt", createdAt)
                .replace("$following", following);        
        if(user == null) {        
            LOG.info("Se debe crear un usuario: " + user);
        } else {            
            LOG.info("Actualizar un usuario");
            input = input.replace("$id", id);
        }
        try {
            user = requestToApi(input, user==null?CreateUser.class: UpdateUser.class);
        } catch (Exception e) {
            user = null;
            result.setDescription("Ha ocurrido un error:" + e.getMessage());
        }
        if(user !=null ){
            result.setError(false);
            result.setStatus("OK");
            result.setDescription("Usuario creado/actualizado correctamente.");
            result.setUser(user);
        } else {
            result.setError(true);
            result.setStatus("NOK");
            
        }
        return ResponseEntity.ok(result);
    }
    
    public User checkUser(String id, String profileUrl) throws IOException {
        String input = ReadFile.readFromInputStream(requestCheckUser.getInputStream());
        input = input.replace("$request", (id!=null&&id.length()>0?"id:\""+id+"\"":"url:\""+profileUrl+"\""));
        LOG.info("input: " + input);
        User user = requestToApi(input, CheckUser.class);
        return user;
    }
    
    public User requestToApi(String input, Class<? extends UserResponse> clazz) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(input, headers);        
        UserResponse o = restTemplate.postForObject(endpoint, entity, clazz);
        if(o != null ) {
            if(o.getErrors() !=null && !o.getErrors().isEmpty()) {
                throw new RuntimeException(o.getErrors().get(0).getMessage());
            }
            return o.getUser();
        }
        return null;
    }
    
}
