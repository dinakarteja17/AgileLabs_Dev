package com.agilelabs.config;
//
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.caffeine.CaffeineCacheManager;
//import org.springframework.context.annotation.Configuration;
//
//import com.github.benmanes.caffeine.cache.Caffeine;
//
//
//@Configuration
//@EnableCaching
//public class CachingConfig {
//	public CacheManager cacheManager() {
//		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
//		cacheManager.setCaffeine(caffeineCacheBuilder());
//		return cacheManager;
//	}
//
//	private Caffeine<Object, Object> caffeineCacheBuilder() {
//		System.out.println(" hello "+Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES) // Set your desired expiration time
//				.maximumSize(100));
//		return Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES) // Set your desired expiration time
//				.maximumSize(100); // Set your desired maximum cache size
//	}
//	
//	
//	
//}

import java.time.Duration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration())
                .transactionAware()
                .build();
    }

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10))
                .disableCachingNullValues();
    }
}
