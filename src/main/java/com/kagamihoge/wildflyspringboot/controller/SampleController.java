package com.kagamihoge.wildflyspringboot.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${spring.profiles.active}")
	String activeProfile;
	
	@Autowired
	DataSource postgresDs;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		logger.info("log");
		logger.info("activeProfile:" + activeProfile);
		logger.info("postgresDs" + postgresDs);
		
		int result1 =jdbcTemplate.queryForObject("select 1", Integer.class);
		logger.info("select 1="+result1);
		
		return "Hello Worldsdf!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
}