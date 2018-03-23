package com.xinqing.example.redis;

import com.xinqing.redis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

/**
 * example
 *
 * Created by xuan on 2018/3/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationTest.class);

    @Autowired
    private RedisService redisService;

    @Test
    public void getResource() {
        Jedis jedis = redisService.getResource();
        LOG.info("jedis: {}", jedis);
    }

    @Test
    public void execute() {
        redisService.execute(jedis -> jedis.set("com.xinqing.example.redis", "ApplicationTest"));
    }

    @Test
    public void executeCallback() {
        String value = redisService.execute(jedis -> jedis.get("com.xinqing.example.redis"), t -> "errorValue");
        LOG.info("value: {}", value);
    }

}
