package com.jack.web;

import com.jack.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private FirstService firstService;

    @GetMapping(value = "/hi")
    public String feignTest(@RequestParam(value = "name") String name){
        System.err.println(name);
        return  firstService.sayHiFromClientOne(name);
    }

    @GetMapping(value = "/hello")
    public String hello(){
        System.err.println("123");
        return firstService.hello();
    }

}
