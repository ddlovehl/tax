package com.ebuy.tax.h5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TaxH5ServerApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TaxH5ServerApplication.class);
		app.run(args);
	}
}
