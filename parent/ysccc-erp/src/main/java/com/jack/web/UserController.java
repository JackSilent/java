package com.jack.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ysccc-erp")
public class UserController {
	
	@PostMapping(value="/user/register")
	public String register() {
		return "".toString();
	}
}
