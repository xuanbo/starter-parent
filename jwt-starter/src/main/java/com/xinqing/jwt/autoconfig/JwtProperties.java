package com.xinqing.jwt.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * jwt属性配置
 *
 * Created by xuan on 2018/3/26
 */
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    /**
     * 过期毫秒数
     */
    private long expire;

    /**
     * 加密字符串
     */
    private String secret;

    /**
     * 签名算法
     *
     * @see io.jsonwebtoken.SignatureAlgorithm
     */
    private String algorithm;

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}
