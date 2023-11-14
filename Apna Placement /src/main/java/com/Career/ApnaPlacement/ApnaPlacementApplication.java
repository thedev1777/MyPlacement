package com.Career.ApnaPlacement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication
//@ConfigurationProperties(prefix = "application.datasource")
//@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.Career.ApnaPlacement.UserDao.UserRepository") 
@ComponentScan(basePackages ="com.Career.ApnaPlacement.UserController")
@EntityScan(basePackages = "com.Career.ApnaPlacement")
public class ApnaPlacementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApnaPlacementApplication.class, args);
	}


	

}
