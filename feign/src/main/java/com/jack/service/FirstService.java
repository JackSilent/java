package com.jack.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "firstclient")
public interface FirstService {

    @RequestMapping(value = "/firstEurekaClient/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/firstEurekaClient/hello",method = RequestMethod.GET)
    String hello();
}
