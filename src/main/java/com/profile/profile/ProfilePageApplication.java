package com.profile.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = "com.profile")
@EnableJpaRepositories("com.profile.profile")
@EntityScan("com.profile.profile")
@SpringBootApplication
public class ProfilePageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilePageApplication.class, args);
	}
}
