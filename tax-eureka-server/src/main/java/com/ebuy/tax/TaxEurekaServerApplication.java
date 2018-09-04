package com.ebuy.tax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TaxEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxEurekaServerApplication.class, args);
	}
}
