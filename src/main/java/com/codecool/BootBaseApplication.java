package com.codecool;

import com.codecool.service.upload.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)

public class BootBaseApplication {


	public static void main(String[] args) {
		SpringApplication.run(BootBaseApplication.class, args);
	}


}
