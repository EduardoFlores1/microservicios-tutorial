package com.example.servidor_discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServidorDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServidorDiscoveryApplication.class, args);
	}

}
