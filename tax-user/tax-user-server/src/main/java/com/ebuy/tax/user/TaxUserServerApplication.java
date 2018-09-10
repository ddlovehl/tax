package com.ebuy.tax.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan(basePackages = "com.ebuy.tax.user.implementation.*.mapper*")
public class TaxUserServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxUserServerApplication.class, args);
	}
}
