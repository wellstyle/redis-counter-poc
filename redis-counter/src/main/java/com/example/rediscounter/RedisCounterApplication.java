package com.example.rediscounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RedisCounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCounterApplication.class, args);
	}
}
