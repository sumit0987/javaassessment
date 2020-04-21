package com.paymenteurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FoodzoneEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodzoneEurekaServerApplication.class, args);
	}

}
