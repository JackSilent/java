package com.jack.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "firstclient")
public interface SchedualServiceHi {

    @GetMapping(value = "/firstEurekaClient/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
