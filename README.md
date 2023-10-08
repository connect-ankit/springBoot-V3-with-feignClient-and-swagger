
# Spring-Boot 3 with Feign client  

Create three services that communicate with each other over HTTP. The first service acts as an orchestrator, making GET and POST requests to the other two services, aggregating their responses, and logging trace information. Additionally, handle exceptions when the JSON in POST requests is invalid.


## Features

- inter microservice communication
- microservices architecture 
- Feign client 
- Rest Template
- distributed logging 
- AOP for centralized logging
- custom java @Anotations
- swagger 3



## Installation

Install my-project with mvn

```bash
  mvn clean install 
  cd first-app/target/docker
  java -jar first-app.jar
```
    
## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the  class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

```bash
  mvn spring-boot:run
```


## 🛠 Skills
Java | Microservice | Docker | Kubernates | Cloud Native | AWS | Angular | Javascript | MySQL  


## Authors

- [[@connect-ankit](https://github.com/connect-ankit)]


## Feedback

If you have any feedback, please reach out to us at ankit4unet@gmail.com
