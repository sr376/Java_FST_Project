package com.example.JDBCdemo;

import com.example.JDBCdemo.model.Alien;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbCdemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(JdbCdemoApplication.class, args);
		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(111);
		alien1.setName("srujan");
		alien1.setTech("java");

	}

}
