package com.ebuy.tax.h5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class TaxH5ServerApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TaxH5ServerApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TaxH5ServerApplication.class);
		app.run(args);
	}
}
