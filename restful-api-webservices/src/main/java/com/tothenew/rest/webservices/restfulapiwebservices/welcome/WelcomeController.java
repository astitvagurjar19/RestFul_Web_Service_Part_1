package com.tothenew.rest.webservices.restfulapiwebservices.welcome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping(path = "/welcome-to-spring-boot")
    public String helloWorld(){
        return "Welcome to spring boot";
    }
}
