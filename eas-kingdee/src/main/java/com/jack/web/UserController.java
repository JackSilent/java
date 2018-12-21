package com.jack.web;

import com.jack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jack
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/login")
    public String userLogin(@RequestParam String name){
        return userService.userLogin(name);
    }
}
