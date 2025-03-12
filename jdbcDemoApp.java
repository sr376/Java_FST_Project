

package com.example.JDBCdemo;

import com.example.JDBCdemo.model.Alien;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbCdemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(JdbCdemoApplication.class, args);
		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(111);
		alien1.setName("srujan");
		alien1.setTech("java");

		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(alien1); // Fixed issue
		System.out.println(repo.findAll());
	}
}
