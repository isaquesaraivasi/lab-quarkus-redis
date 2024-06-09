package br.com.lab.service;

import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.value.ValueCommands;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.Duration;


@ApplicationScoped
public class RedisService {

    @Inject
    private RedisDataSource redisDataSource;

    private ReactiveKeyCommands<String> keyCommands;
    private ValueCommands<String, String> countCommands;

    public RedisService(RedisDataSource redisDataSource, ReactiveRedisDataSource reactiveRedisDataSource) {
        countCommands = redisDataSource.value(String.class);
        keyCommands = reactiveRedisDataSource.key();
    }

    public void set(String key, String value) {
        countCommands.setex(key, 60L, value);
    }

    public String get(String key) {
        String value = countCommands.get(key);
        return value;
    }
}
