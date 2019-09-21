package com.thmarket.api;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ServiceApi {

    private int a = 0;

//    private AtomicInteger b = new AtomicInteger(0);

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("/api/order")
    public String order() {

//        synchronized(this) {
//            a++;
//            System.out.println("=================>" + a);
//        }

//        System.out.println("=================>" + b.incrementAndGet());

        RLock lock = redissonClient.getLock("test_lock");
        lock.lock();

        a++;
        System.out.println("=================>" + a);

        lock.unlock();

        return String.valueOf(a);
    }
}
