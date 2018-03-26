package com.xinqing.jwt.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.util.Map;

/**
 * jwt service
 *
 * Created by xuan on 2018/3/26
 */
public interface JwtService {

    /**
     * 生成token
     *
     * @param claims the JWT claims to be set as the JWT body.
     * @return token
     */
    String build(Map<String, Object> claims);

    /**
     * 验证token是否合法
     *
     * @param token token
     * @throws ExpiredJwtException      if the specified JWT is a Claims JWT and the Claims has an expiration time
     * @throws UnsupportedJwtException  if the {@code claimsJws} argument does not represent an Claims JWS
     * @throws MalformedJwtException    if the {@code claimsJws} string is not a valid JWS
     * @throws SignatureException       if the {@code claimsJws} JWS signature validation fails
     *                                  before the time this method is invoked.
     * @throws IllegalArgumentException if the {@code claimsJws} string is {@code null} or empty or only whitespace
     * @return Claims Claims
     */
    Claims parser(String token)
            throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException;
}
