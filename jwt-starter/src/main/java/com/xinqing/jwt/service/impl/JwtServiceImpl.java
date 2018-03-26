package com.xinqing.jwt.service.impl;

import com.xinqing.jwt.autoconfig.JwtProperties;
import com.xinqing.jwt.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Map;

/**
 * jwt service impl
 *
 * Created by xuan on 2018/3/26
 */
public class JwtServiceImpl implements JwtService {

    private static final String PREFIX = "Bearer ";

    private final JwtProperties properties;

    private final SignatureAlgorithm signatureAlgorithm;

    public JwtServiceImpl(JwtProperties properties) {
        this.properties = properties;
        this.signatureAlgorithm = SignatureAlgorithm.forName(properties.getAlgorithm());
    }

    @Override
    public String build(Map<String, Object> claims) {
        String jwt = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + properties.getExpire()))
                .signWith(signatureAlgorithm, properties.getSecret())
                .compact();
        return PREFIX + jwt; // jwt前面一般都会加Bearer
    }

    @Override
    public Claims parser(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException {
        if (StringUtils.isEmpty(token)) {
            throw new IllegalArgumentException("argument token is empty");
        }
        // parse the token.
        return Jwts.parser()
                .setSigningKey(properties.getSecret())
                .parseClaimsJws(token.replace(PREFIX, ""))
                .getBody();
    }
}
