package com.byebye.kzj.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.byebye.kzj.dao")
//@SpringBootApplication(scanBasePackages = "com.byebye.kzj.*")
@SpringBootApplication
@ComponentScan({"com.byebye.kzj.service.*","com.byebye.kzj.admin.*"})
public class CloudBaicAdminApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CloudBaicAdminApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CloudBaicAdminApplication.class, args);
	}
}
