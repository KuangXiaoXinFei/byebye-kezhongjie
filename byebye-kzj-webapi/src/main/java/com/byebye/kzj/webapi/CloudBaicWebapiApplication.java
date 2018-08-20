package com.byebye.kzj.webapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
@MapperScan("com.cloudyoung.baic.webapi.dao")
public class CloudBaicWebapiApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CloudBaicWebapiApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(CloudBaicWebapiApplication.class, args);
	}

}
