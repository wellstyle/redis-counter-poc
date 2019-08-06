package com.example.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@RestController
public class FeignApplication {

	@Autowired
	private CounterClient counterClient;

	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}

	@GetMapping("/count")
	public ResponseEntity<Integer> count() {
		return counterClient.count();
	}

}
