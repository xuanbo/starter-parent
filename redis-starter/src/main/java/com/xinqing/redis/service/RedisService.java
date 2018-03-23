package com.xinqing.redis.service;

import com.xinqing.redis.func.ErrorCallback;
import com.xinqing.redis.func.JedisHandler;
import redis.clients.jedis.Jedis;

/**
 * redis service
 *
 * Created by xuan on 2018/3/23
 */
public interface RedisService {

    /**
     * 获取jedis实例
     *
     * @return Jedis
     */
    Jedis getResource();

    /**
     * 执行
     *
     * @param handler JedisHandler
     * @param <T> 执行结果类型
     * @return 执行结果，发生异常会返回null
     */
    <T> T execute(JedisHandler<T> handler);

    /**
     * 执行，异常回调
     *
     * @param handler JedisHandler
     * @param callback 异常回调
     * @param <T> 执行结果类型
     * @return 执行结果，错误发生异常会调用callback
     */
    <T> T execute(JedisHandler<T> handler, ErrorCallback<T> callback);

}
