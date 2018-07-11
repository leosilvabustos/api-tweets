/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zenta.apitweets.createtweet;

import com.zenta.apitweets.business.http.api.ApiResponse;
import com.zenta.apitweets.business.pojo.Tweet;
import com.zenta.apitweets.business.utils.ReadFile;
import com.zenta.apitweets.createtweet.http.ApiTweetResult;
import com.zenta.apitweets.createtweet.http.CreateTweetResponse;
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
@RequestMapping("/create-tweet")
public class RestController {
    
    private final Logger LOG = LoggerFactory.getLogger(RestController.class);
    
    private final RestTemplate restTemplate;
    private static final String API_URL = "http://localhost:8000/tweets";
    
    @Value("classpath:request-createtweet")
    private Resource requestCreateTweet;
    
    @Autowired
    public RestController(RestTemplate rt) {
        this.restTemplate = rt;
    }
    
    @PostMapping
    public ResponseEntity createTweet(
            @RequestBody(required=false) String query,
            @RequestParam(value="text") String text, 
            @RequestParam(value="source") String source, 
            @RequestParam(value="truncated", required=false) String truncated, 
            @RequestParam(value="inReplyToStatus",required=false) String inReplyToStatus,
            @RequestParam(value="inReplyToUser",required=false) String inReplyToUser,
            @RequestParam(value="inReplyToScreen",required=false) String inReplyToScreen,
            @RequestParam(value="createdAt") String createdAt,
            @RequestParam(value="favorited",required=false) String favorited,
            @RequestParam(value="favoritedCount",required=false) String favoritedCount,
            @RequestParam(value="retweeted",required=false) String retweeted,
            @RequestParam(value="retweetedCount",required=false) String retweetedCount,
            @RequestParam(value="urls[]",required=false) String[] urls,
            @RequestParam(value="hashtags[]",required=false) String[] hashtags,
            @RequestParam(value="userName") String userName,
            @RequestParam(value="userProfileUrl") String userProfileUrl,
            @RequestParam(value="userCreatedAt") String userCreatedAt,
            @RequestParam(value="userFollowing") String userFollowing
        ) throws IOException{
        
        LOG.info("create-tweet [" +
                "text: "+text+
                ", source: "+source+
                ", truncated: "+truncated+
                ", inReplyToStatus: "+inReplyToStatus+
                ", inReplyToUser: "+inReplyToUser+
                ", inReplyToScreen: "+inReplyToScreen+
                ", createdAt: "+createdAt+
                ", favorited: "+favorited+
                ", favoritedCount: "+favoritedCount+
                ", retweeted: "+retweeted+
                ", retweetedCount: "+retweetedCount+
                ", urls: "+(urls!=null?urls.length:"0")+
                ", hashtags: "+(hashtags!=null?hashtags.length:"0")+
                ", userName: "+userName+
                ", userProfileUrl: "+userProfileUrl+
                ", userCreatedAt: "+userCreatedAt+
                ", userFollowing: "+userFollowing+
                "]");
        
        ApiTweetResult result = new ApiTweetResult();
        
        String input = ReadFile.readFromInputStream(requestCreateTweet.getInputStream());
        String _url = "[";
        if(urls != null && urls.length > 0) {            
            for (String url : urls) {
                _url += _url.length()>1?",":"";
                _url += "\""+url+"\"";
            }            
        }
        _url += "]";
        String _hashtag = "[";
        if(hashtags != null && hashtags.length > 0) {            
            for (String hashtag : hashtags) {
                _hashtag += _hashtag.length()>1?",":"";
                _hashtag += "\""+hashtag+"\"";
            }            
        }
        _hashtag += "]";
        input = input.replace("$text", text)
                .replace("$source", source)
                .replace("$truncated", notNullOrEmpty(truncated)?truncated:"false")
                .replace("$inReplyToStatus", notNullOrEmpty(inReplyToStatus)?inReplyToStatus:"0")
                .replace("$inReplyToUser", notNullOrEmpty(inReplyToUser)?inReplyToUser:"0")
                .replace("$inReplyToScreen", notNullOrEmpty(inReplyToScreen)?inReplyToScreen:"0")
                .replace("$createdAt", createdAt)
                .replace("$favoritedCount", notNullOrEmpty(favoritedCount)?favoritedCount:"0")
                .replace("$favorited", notNullOrEmpty(favorited)?favorited:"false")                
                .replace("$retweetedCount", notNullOrEmpty(retweetedCount)?retweetedCount:"false")
                .replace("$retweeted", notNullOrEmpty(retweeted)?retweeted:"false")
                .replace("$userName", userName)
                .replace("$userProfileUrl", userProfileUrl)
                .replace("$userCreatedAt", userCreatedAt)
                .replace("$userFollowing", notNullOrEmpty(userFollowing)?userFollowing:"false")
                .replace("$urls", _url)
                .replace("$hashtags", _hashtag)
                ;
        
        CreateTweetResponse apiResponse = requestToApi(input);
        
        if(apiResponse != null && (apiResponse.getErrors()==null || apiResponse.getErrors().isEmpty())) {
            result.setError(false);
            result.setStatus("OK");
            result.setDescription("Se ha creado correctamente el tweet");
            result.setTweet((Tweet) apiResponse.getTweet());
        } else {
            result.setError(true);
            result.setStatus("NOK");
            result.setDescription("Ha ocurrido un error: " + 
                    ((apiResponse!=null&&apiResponse.getErrors()!=null&&!apiResponse.getErrors().isEmpty())
                    ?apiResponse.getErrors().get(0).getErrorType():"No identificado"));
        }
        
        return ResponseEntity.ok(result);
    }
    
    public CreateTweetResponse requestToApi(String input) {
        
        LOG.info("Request api: " + input);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(input, headers);
        CreateTweetResponse rest = restTemplate.postForObject(API_URL, entity, CreateTweetResponse.class);
        return rest;
    }
    
    public boolean notNullOrEmpty(String s) {
        return s!=null&&s.trim().length()>0;
    }
}
