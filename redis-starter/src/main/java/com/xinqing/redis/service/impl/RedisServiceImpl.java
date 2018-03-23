package com.xinqing.redis.service.impl;

import com.xinqing.redis.func.ErrorCallback;
import com.xinqing.redis.func.JedisHandler;
import com.xinqing.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

import java.util.Objects;

/**
 * redis service impl
 *
 * Created by xuan on 2018/3/23
 */
public class RedisServiceImpl implements RedisService {

    private static final Logger LOG = LoggerFactory.getLogger(RedisServiceImpl.class);

    private final Pool<Jedis> pool;

    public RedisServiceImpl(Pool<Jedis> pool) {
        this.pool = pool;
    }

    @Override
    public Jedis getResource() {
        return pool.getResource();
    }

    @Override
    public <T> T execute(JedisHandler<T> handler) {
        return execute(handler, t -> null);
    }

    @Override
    public <T> T execute(JedisHandler<T> handler, ErrorCallback<T> callback) {
        Jedis jedis = null;
        try {
            // 池中获取jedis实例
            jedis = pool.getResource();
            // 具体执行
            return handler.handle(jedis);
        } catch (Throwable t) {
            LOG.error("execute exception", t);
            // 处理异常
            return callback.onError(t);
        } finally {
            // 释放连接
            if (Objects.nonNull(jedis)) {
                jedis.close();
            }
        }
    }
}
