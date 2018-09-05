package com.ebuy.tax.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.ebuy.tax.user.implementation.user.mapper")
public class TaxUserServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxUserServerApplication.class, args);
	}
}