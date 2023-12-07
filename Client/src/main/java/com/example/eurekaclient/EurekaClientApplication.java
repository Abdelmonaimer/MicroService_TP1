package com.example.eurekaclient;

import com.example.eurekaclient.Model.Client;
import com.example.eurekaclient.Repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(EurekaClientApplication.class, args);


	}
	@Bean
	CommandLineRunner initialiserBaseH2(ClientRepository cr){
		return args ->{
			cr.save(new Client(Long.parseLong("1"),"ERRAJI Abdelmonaim",Float.parseFloat("23")));
			cr.save(new Client(Long.parseLong("2"),"ERRAIJ Ahmed",Float.parseFloat("22")));
			cr.save(new Client(Long.parseLong("3"),"OUATIL Anas",Float.parseFloat("21")));
		};
	}

}
