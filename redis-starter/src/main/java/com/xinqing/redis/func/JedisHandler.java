package com.xinqing.redis.func;

import redis.clients.jedis.Jedis;

/**
 * jedis handler
 *
 * Created by xuan on 2018/3/23
 */
@FunctionalInterface
public interface JedisHandler<T> {

    /**
     * 具体处理方法
     *
     * @param jedis Jedis实例
     * @return 执行结果
     */
    T handle(Jedis jedis);

}
