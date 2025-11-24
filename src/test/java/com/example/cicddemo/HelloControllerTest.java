package com.example.cicddemo;

import com.example.cicddemo.controller.HelloController;
import com.example.cicddemo.service.HelloService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerTest {

    @Test
    public void testHello() {
        HelloService service = new HelloService();
        HelloController controller = new HelloController(service);

        assertEquals("Hello from CI/CD Spring Boot App!", controller.sayHello());
    }
}
