package com.ellenmateus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class PicPayDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicPayDesafioApplication.class, args);
	}

}
