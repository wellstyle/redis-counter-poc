package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("counter-api")
public interface CounterClient {
    @GetMapping(value = "/counter")
    ResponseEntity<Integer> count();
}
