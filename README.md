# API Tweets

El proyecto está asociado a la creación de microservicios en una arquitectura de Domain Driven Design. El proyecto consta de la los siguientes módulos:
1. **api-tweets-business:** Librerías de código reutilizables.
1. **api-tweets-configuration:** Proyecto de spring config que carga las configuraciones del proyecto.
1. **api-tweets-createorupdateuser:** Exposición de servicio que genera las operaciones de usuarios.
1. **api-tweets-createtweet:** Exposición del servicio que crea los tweeter.
1. **api-tweets-gettweets:** Expesición del servicio que lista los tweets.
1. **api-tweets-graphql:** API de acceso a los datos por medio de Graphql
------------

Para la instalación se debe contar con las siguientes librerías:

`Java JDK 8`

`Apache Maven 3.5`

------------

Dentro de las carpetas de cada módulo se debe ejecutar el siguiente comando:


    cd api-tweets/api-tweets-business/
    mvn clean install

Lo que generara un carpeta target dentro de la cual se genera un ejecutable con el nombre del proyecto más la versión en este caso **1.0-SNAPSHOT** ejemplo:

`api-tweets/api-tweets-business/api-tweets-graphql-1.0-SNAPSHOT.jar`


Para ejecutar las aplicaciones desde local se debe ejecutar el comando java -jar apuntando a los ejecutables antes mencionados, por defecto toma el puerto configurado por aplicación en la carpeta config.

`java -jar api-tweets/api-tweets-business/api-tweets-graphql-1.0-SNAPSHOT.jar`

Las aplicaciones que deben generarse como ejecutables son los siguientes:

1. api-tweets-graphql
1. api-tweets-createorupdateuser
1. api-tweets-createtweet
1. api-tweets-gettweets
