package com.example.cicddemo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getMessage() {
        return "Hello from CI/CD Spring Boot App!";
    }
}
