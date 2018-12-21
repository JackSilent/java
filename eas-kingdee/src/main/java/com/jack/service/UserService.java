package com.jack.service;

import com.jack.fall_back.SchedualServiceUserLoginHystricImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Jack
 */
@FeignClient(value = "firstclient" ,fallback = SchedualServiceUserLoginHystricImpl.class)
public interface UserService {

    @RequestMapping(value = "/firstEurekaClient/hi",method = RequestMethod.GET)
    public String userLogin(@RequestParam String name);
}
