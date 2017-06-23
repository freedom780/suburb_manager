## Technology
The following frameworks and technologies have been selected to implement the application

| Framework / Technology | Description |
| ------ | ------ |
| [Spring Boot](https://projects.spring.io/spring-boot/) | Spring Application Framework in addition to Spring Boot has been selected for streamlining the development process|
| [Spring Data Rest](http://projects.spring.io/spring-data-rest/) |  This Spring module is used to minimise the amount of boilerplate code around REST API endpoints and persistence  |
| [Spring Security](https://projects.spring.io/spring-security/) + [Spring OAuth](http://projects.spring.io/spring-security-oauth/)|  Security Framework |
| [HATEOAS](https://en.wikipedia.org/wiki/HATEOAS) (Hypermedia as the Engine of Application State)  |  For stricter REST compliance including navigation and pagination and more control on the server side |
|[JWT](https://tools.ietf.org/html/rfc7519) (JSON web token) format | Refer to [official documentation](https://tools.ietf.org/html/rfc7519) |
|[JPA](http://docs.oracle.com/javaee/6/tutorial/doc/bnbpz.html) / [Hibernate](http://hibernate.org/)| Persistence |
|[JSR - 303](http://beanvalidation.org/1.0/spec/) Bean Validation | Validation technology at the domain model class field level |
|Error & Exception Handling| Spring ResponseEntityExceptionHandler and ControllerAdvice features are used for fine-tuning error and exception handling |

## Security
The OAuth 2.0 standard has been selected for securing API for authorised access from mobile applications:
* **OAuth Authorisation Code flow without client secret** has been chosen as stipulated from the official document [OAuth 2.0 for Native Apps](https://tools.ietf.org/html/draft-ietf-oauth-native-apps-12)
* **PKCE mechanism not introduced** due to sheer amount of work and lack of immediate support from the Spring Security OAuth module (refer to the [open ticket](https://github.com/spring-projects/spring-security-oauth/pull/675) )
* **Full stack of automated end-to-end integration tests** is available in the source code


## Authorisation Code Flow
The end-to-end flow is depicted below.

The API application has co-located Authorisation Server and Resource Server.

```
       +~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+
       |          User Device          |
       |                               |
       | +--------------------------+  | (5) Authorization  +---------------+
       | |                          |  |     Code           |               |
       | |        Client App        |---------------------->|     Token     |
       | |                          |<----------------------|    Endpoint   |
       | +--------------------------+  | (6) Access Token,  |               |
       |   |             ^             |     Refresh Token  +---------------+
       |   |             |             |
       |   |             |             |
       |   | (1)         | (4)         |
       |   | Authorizat- | Authoriza-  |
       |   | ion Request | tion Code   |
       |   |             |             |
       |   |             |             |
       |   v             |             |
       | +---------------------------+ | (2) Authorization  +---------------+
       | |                           | |     Request        |               |
       | |          Browser          |--------------------->| Authorization |
       | |                           |<---------------------|    Endpoint   |
       | +---------------------------+ | (3) Authorization  |               |
       |                               |     Code           +---------------+
       +~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+
```

