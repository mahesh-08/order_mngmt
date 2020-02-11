package com.novogold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.novogold.bean.User;
//import com.novogold.dao.UserDao;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = {"com"})
public class NovogoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovogoldApplication.class, args);
		
	}

}
