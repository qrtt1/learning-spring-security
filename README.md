## Learning Spring Security

### Lab 1

* A simple restful api
    * `/` allows all requests and returns "home"
    * `/users` needs an authenticated user and returns "users"

* Create an security filter to verify HTTP Request with header `x-twjug-lite`
    * allow token `spring-security-is-easy`