package com.ssafy.homework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = { "com.ssafy.homework.model.repository" })
@SpringBootApplication
public class FrameworkHw06Application {
	public static void main(String[] args) {
		SpringApplication.run(FrameworkHw06Application.class, args);
	}
}
