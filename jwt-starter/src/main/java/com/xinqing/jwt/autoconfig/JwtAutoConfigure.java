package com.xinqing.jwt.autoconfig;

import com.xinqing.jwt.service.JwtService;
import com.xinqing.jwt.service.impl.JwtServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * jwt自动配置
 *
 * Created by xuan on 2018/3/26
 */
@Configuration
@EnableConfigurationProperties(JwtProperties.class)
public class JwtAutoConfigure {

    private JwtProperties jwtProperties;

    @Bean
    public JwtService jwtService() {
        return new JwtServiceImpl(jwtProperties);
    }

}
