package com.tony.jwt;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.DateUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2019/11/2
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
@Slf4j
public class JwtUtils {


    @Test
    public void test1() {
        Map<String, Object> header = new HashMap<>();
        header.put("typ","JWT");
        header.put("alg", "HS256");
        String secret = "mystar";

        String sign = JWT.create().withClaim("from_user", "B").withClaim("target_user", "A").
                withHeader(header)
                .withExpiresAt(DateUtil.tomorrow())
                .sign(Algorithm.HMAC256(secret));
        log.info("sign: {}", sign); // eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0YXJnZXRfdXNlciI6IkEiLCJleHAiOjE1NzI3NTAxMzcsImZyb21fdXNlciI6IkIifQ.Z6QU8jA1FjUwT2RRQ0nEQFmGS-xzt6aHeAaoTe82gAM

    }

    @Test
    public void test2() {
//        String sign = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0YXJnZXRfdXNlciI6IkEiLCJleHAiOjE1NzI3NTAxMzcsImZyb21fdXNlciI6IkIifQ.Z6QU8jA1FjUwT2RRQ0nEQFmGS-xzt6aHeAaoTe82gAM";
        String sign = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0YXJnZXRfdXNlciI6IkEiLCJmcm9tX3VzZXIiOiJCIiwiZXhwIjoxNTcyNzU5NDQ0fQ.Ho0R3mTr0rLFp2PTSS4QK0Rz_TKqTZ0uouvWHMuNBuM";

        String token = JWT.decode(sign).getToken();
        log.info("token is :{}", token);
        String signature = JWT.decode(sign).getSignature();
        log.info("signature is : {}", signature);
    }

    /**
     * 测试jjwt包算法生成的结果
     */
    @Test
    public void test3() {
        String secret = "mystar";

        Map<String, Object> header = new HashMap<>();
        header.put("typ","JWT");
        header.put("alg", "HS256");

        Map<String, Object> claims = new HashMap<>();
        claims.put("from_user","B");
        claims.put("target_user", "A");

        String token = Jwts.builder().addClaims(claims).setHeader(header).signWith(SignatureAlgorithm.HS256, secret)
                .setExpiration(DateUtil.tomorrow()).compact();
        log.info("sign: {}", token); // eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0YXJnZXRfdXNlciI6IkEiLCJmcm9tX3VzZXIiOiJCIiwiZXhwIjoxNTczMTgxMTY1fQ.stGQaW8Fm0ArLH84k4gS-fceAcHaYirTHRzxhDmcjx8
    }

    /**
     * 测试jjwt包算法生成的结果与java-jwt包的结果是否一致.
     */
    @Test
    public void test4() {
        test1();
        test3();
    }


    /**
     * 测试jjwt包算法生成的结果
     */
    @Test
    public void test5() {
        String secret = "iloveyou";

        Map<String, Object> header = new HashMap<>();
        header.put("typ","JWT");
        header.put("alg", "HS256");

        Map<String, Object> claims = new HashMap<>();
        claims.put("data","915086");
//        claims.put("data","97677bc4d1dd2de57c7e19ec3d402a9a");
        claims.put("isLogin", 1);
        claims.put("exp", 1573181165);

        String token = Jwts.builder().addClaims(claims).setHeader(header).signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        log.info("sign: {}", token); // eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc0xvZ2luIjoxLCJkYXRhIjoiOTE1MDg2IiwiZXhwIjoxNTczMTgyMjg0fQ.o1gEBW12GoKbKD7-Z8t5rFrzaMNyZA8hHpdmeH8PmQ8
    }

    /**
     * 双重加密
     */
    @Test
    @SneakyThrows
    public void test6() {
        String secret = "iloveyou";

        Map<String, Object> header = new HashMap<>();
        header.put("typ","JWT");
        header.put("alg", "HS256");

        Map<String, Object> claims = new HashMap<>();
        claims.put("data","915086");
//        claims.put("data","97677bc4d1dd2de57c7e19ec3d402a9a");
        claims.put("isLogin", 1);
        claims.put("exp", 1573181165);

        String json = JSON.toJSONString(claims);
        log.info("json:{}",json);
        String encrypt = DesUtil.encrypt(json, secret);
        log.info("encrypt:{}",encrypt);
        String decrypt = DesUtil.decrypt(encrypt, secret);
        log.info("decrype:{}",decrypt);

        String token = Jwts.builder().setPayload(encrypt).setHeader(header).signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        log.info("sign: {}", token); // eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.RUE0NDU2MzFBMEVDNEUyOThERDY4QUFGNUYzMjkyN0Y3NTQ0NzFGRTEzMEY0OEJEMUY5MzVCRjZFRTE4N0RFMDhBOTkyQTQ0OTJDRkQwRDY4MDI3QUMxNjgwMzg3RDUx.eUFTRr3WU5kRhkMwS2iPmvddCC3EZGgSD6iNofnKVIY
    }



}
