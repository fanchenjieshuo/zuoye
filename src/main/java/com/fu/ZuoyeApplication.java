package com.fu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fu.mapper")
public class ZuoyeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuoyeApplication.class, args);
	}

}
