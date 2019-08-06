package com.example.rediscounter.web;

import com.example.rediscounter.service.CounterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/counter")
public class CounterController {

    private static final int LIMIT_COUNT = 500;
    private final CounterService counterService;

    @GetMapping
    public ResponseEntity<Integer> count() {
        int count = counterService.addAndGet();
        log.info("### count={}", count);
        if (count <= LIMIT_COUNT) {
            return new ResponseEntity<Integer>(count, HttpStatus.OK);
        } else {
            return new ResponseEntity<Integer>(count, HttpStatus.BAD_REQUEST);
        }
    }
}
