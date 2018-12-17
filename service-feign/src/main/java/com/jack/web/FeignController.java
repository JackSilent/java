package com.jack.web;

import com.jack.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private SchedualServiceHi serviceHi;

    @GetMapping("/feignTest")
    public String test(@RequestParam(value = "name") String name){
        return serviceHi.sayHiFromClientOne(name);
    }
}
