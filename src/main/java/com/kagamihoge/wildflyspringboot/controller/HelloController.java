package com.kagamihoge.wildflyspringboot.controller;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/hello")
	public String hello(Model model) {
		 model.addAttribute("message", "Hello Thymeleaf!!");
		return "hello";
	}
	
	@GetMapping("hello2")
	public String hello2(@RequestParam(name="param") @NotEmpty @NotNull String param) {
		logger.info("param=" + param);
		return "hello";
	}
}
