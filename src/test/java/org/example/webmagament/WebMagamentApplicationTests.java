package org.example.webmagament;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

@SpringBootTest
class WebMagamentApplicationTests {
    private String key = "a1b2c3d4e5f6g7h8a1b2c3d4e5f6g7h8a1b2c3d4e5f6g7h8a1b2";

    @Test
    void contextLoads() {
    }

    @Test
    public void testGenJwt() {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("name", "zhangsan");
        claims.put("age", 18);

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)//签名算法与密钥
                .setClaims(claims)//自定义内容(载荷)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 3600))//设置有效期
                .compact();
        System.out.println(jwt);
    }

    //解析Jwt
    @Test
    public void testParseJwt() {
        // 解析JWT
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiemhhbmdzYW4iLCJhZ2UiOjE4LCJleHAiOjE3NTIzMDgyOTZ9.EYdlW97Bs3xIsRBCNsVkgrk7Tp97Mr5QdQPaIR6dgaA")
                .getBody();
        System.out.println(claims);
    }

}
