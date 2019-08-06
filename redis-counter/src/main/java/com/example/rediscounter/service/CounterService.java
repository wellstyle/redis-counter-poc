package com.example.rediscounter.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private final RedisAtomicInteger redisAtomicInteger;

    public CounterService(RedisTemplate redisTemplate) {
        this.redisAtomicInteger = new RedisAtomicInteger("counter", redisTemplate.getConnectionFactory(), 0);
    }

    public int addAndGet() {
        return redisAtomicInteger.addAndGet(1);
    }
}
