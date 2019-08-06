package com.example.rediscounter;

import com.example.rediscounter.service.CounterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCounterApplicationTests {

	@Autowired
	private CounterService counterService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void concurrentTest() throws InterruptedException {
		int numThreads = 500;
		ExecutorService threadPool = Executors.newFixedThreadPool(numThreads);
		for (int i = 0; i < numThreads; i++) {
			threadPool.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println("counter=" + counterService.addAndGet());
				}
			});
		}
		threadPool.shutdown();
		threadPool.awaitTermination(5, TimeUnit.SECONDS);
	}


}
