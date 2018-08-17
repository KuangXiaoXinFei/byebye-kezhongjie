package com.cloudyoung.baic.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.cloudyoung.baic.dao")
//@SpringBootApplication(scanBasePackages = "com.cloudyoung.baic.*")
@SpringBootApplication
@ComponentScan({"com.cloudyoung.baic.service.*","com.cloudyoung.baic.admin.*"})
public class CloudBaicAdminApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CloudBaicAdminApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudBaicAdminApplication.class, args);
	}
}
