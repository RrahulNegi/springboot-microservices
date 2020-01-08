package com.mailService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MailServiceStarter {

	public static void main(String[] args) {
		System.out.println("IN MailServer  ");
		SpringApplication.run(MailServiceStarter.class, args);
	}

}
