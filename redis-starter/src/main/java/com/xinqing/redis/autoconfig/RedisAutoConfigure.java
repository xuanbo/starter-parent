package com.xinqing.redis.autoconfig;

import com.xinqing.redis.service.RedisService;
import com.xinqing.redis.service.impl.RedisServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.util.Pool;

import java.util.Objects;

/**
 * redis自动配置
 *
 * Created by xuan on 2018/3/23
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisAutoConfigure {

    private static final Logger LOG = LoggerFactory.getLogger(RedisAutoConfigure.class);

    @Autowired
    private RedisProperties properties;

    @Bean
    public Pool<Jedis> pool() {
        JedisPoolConfig poolConfig = properties.getPool() == null ? new JedisPoolConfig() : jedisPoolConfig();
        if (Objects.nonNull(properties.getSentinel())) {
            LOG.info("redis sentinel nodes: {}", properties.getSentinel().getNodes());
            RedisProperties.Sentinel sentinel = properties.getSentinel();
            return new JedisSentinelPool(sentinel.getMaster(), sentinel.getNodes(), poolConfig, properties.getTimeout(),
                    properties.getPassword(), properties.getDatabase());
        }
        LOG.info("redis pool host: {}", properties.getHost());
        return new JedisPool(poolConfig, properties.getHost(), properties.getPort(), properties.getTimeout(),
                properties.getPassword(), properties.getDatabase(), properties.isSsl());
    }

    @Bean
    public RedisService redisService() {
        return new RedisServiceImpl(pool());
    }

    private JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        RedisProperties.Pool props = properties.getPool();
        config.setMaxTotal(props.getMaxActive());
        config.setMaxIdle(props.getMaxIdle());
        config.setMinIdle(props.getMinIdle());
        config.setMaxWaitMillis(props.getMaxWait());
        return config;
    }
}
