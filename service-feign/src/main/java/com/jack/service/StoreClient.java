package com.jack.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "first-eureka-client")
public interface StoreClient {

    @GetMapping(value = "/test")
    public String test(String name);

}