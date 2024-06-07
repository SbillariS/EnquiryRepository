package com.carlelo.enquiry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EnquiryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnquiryServiceApplication.class, args);
	}
	@Bean
	public RestTemplate rs()
	{
		RestTemplate rt=new RestTemplate();
		return rt;
				
	}

}
