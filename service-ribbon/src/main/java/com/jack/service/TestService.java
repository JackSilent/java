package com.jack.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author jack
 */

@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;

    public String helloTest(String name){
        return restTemplate.getForObject("http://FIRST-EUREKA-CLIENT/firstEurekaClient/test?name="+name,String.class);
    }

    public String JsonTest(HttpServletRequest request){
        String string = request.getParameter("upLoadData");
        return  restTemplate.postForObject("http://FIRST-EUREKA-CLIENT/firstEurekaClient/jsonTest",string,String.class);
    }

}
