package com.rest.webservices.restfulwebservices.Filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
    
    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("value1", "password", "value3");
    }
}
