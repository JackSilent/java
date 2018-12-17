package com.jack.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jack.entity.UploadData;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author jack
 */
@RestController
@RequestMapping(value = "firstEurekaClient")
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        System.err.println("123123");
        return "这是由firstEurekaClient处理的\nhellow";
    }

    @GetMapping("/hi")
    public String hi(@RequestParam(value = "name")String name){
        System.err.println("123123");
        return "这是由firstEurekaClient处理的\n"+name;
    }


    @GetMapping("/test")
    public String test(String name){
        System.err.println("123123");
        return "这是由firstEurekaClient处理的\n"+name;
    }

    @PostMapping(value = "/jsonTest")
    public String jsonTest(@RequestBody String string){
        System.err.println(string);

        ObjectMapper mapper = new ObjectMapper();
        try {
            UploadData uploadData = mapper.readValue(string,UploadData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String("123");
    }
}
