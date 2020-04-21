package com.foodzone;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.foodzone.config.RibbonConfiguration;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
@RibbonClient(name="bankclient",configuration=RibbonConfiguration.class)
public class FoodzoneServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodzoneServiceApplication.class, args);
	}

}
