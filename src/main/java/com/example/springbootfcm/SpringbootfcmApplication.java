package com.example.springbootfcm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootfcmApplication {
	
	public static final Logger logger = LoggerFactory.getLogger("com.example.springbootfcm");

	public static void main(String[] args) {
		SpringApplication.run(SpringbootfcmApplication.class, args);
	}

}
