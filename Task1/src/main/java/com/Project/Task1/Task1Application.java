package com.Project.Task1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@ComponentScan("com.Project")
@EnableEurekaClient
public class Task1Application {

	public static void main(String[] args) {
		SpringApplication.run(Task1Application.class, args);
	}

}
