package com.dyno.cache.configuration;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.CaffeineSpec;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by artem on 3/18/20.
 */
@Configuration
@EnableCaching
public class CacheConfiguration {


    //Global usage for Cacheble through the spring CacheManager
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager requestCache = new CaffeineCacheManager("requestCache");
        requestCache.setCaffeineSpec(CaffeineSpec.parse("maximumSize=500,expireAfterAccess=3s"));
        return requestCache;
    }

    @Bean
    public Cache<String, Set<String>> caffeineCache() {
        return Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.HOURS)
                //.maximumSize(100)
                .build();
    }

    @Bean
    public Cache<String, Object> objectCache() {
        return Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.HOURS)
                //.maximumSize(100)
                .build();
    }

}
