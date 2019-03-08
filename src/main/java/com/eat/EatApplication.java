package com.eat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * 시큐리티 디저블 처리
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EatApplication {

	public static void main(String[] args) {
		System.out.println("EatApplication.main");
		System.out.println("123123");
		SpringApplication.run(EatApplication.class, args);
	}

}

