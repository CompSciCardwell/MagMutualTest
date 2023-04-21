package com.cardwell.MagMutualTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class UserSearchApplication {

	public static void main(String... args) {
		SpringApplication.run(UserSearchApplication.class, args);
	}
}
