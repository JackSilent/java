package com.jack.web;

import com.jack.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jack
 */

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping(value = "/hi")
    public String helloTest(String name){
        System.err.println("6666666");
        return testService.helloTest(name);
    }

    @PostMapping(value = "/jsonTest")
    public String jsonTest(HttpServletRequest request){
        System.err.println("进来了");
        return testService.JsonTest(request);
    }
}
