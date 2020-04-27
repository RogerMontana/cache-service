package com.dyno.cache.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;


@Service
@CacheConfig(cacheNames = {"requestCache"})
public class RequestService {
    private AtomicInteger integer = new AtomicInteger(1);

    @Cacheable
    public String getIteration(String id) {
        return String.valueOf(integer.incrementAndGet()) + id;
    }
}
