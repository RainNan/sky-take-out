package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Slf4j
public class RedisConfiguration {
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        log.info("开始创建redis模板类");
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
////        redisTemplate.setKeySerializer(new StringRedisSerializer());
//
//        return redisTemplate;


        RedisTemplate redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 设置Key的序列化器为String
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        // 设置Value的序列化器为String
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        // 设置Hash Key的序列化器为String
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//
//        // 设置Hash Value的序列化器为String
//        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
