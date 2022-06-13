package com.example.userservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;


@Slf4j
public class JwtTokenProvider { // JWT 토큰을 통한 인증을 설정
    private static final String JWT_SECRET = "secretKey";

    // 토큰 유효 시간 설정
    private static final int JWT_EXPIRATION_MS = 1000 * 60 * 60 * 24 * 7; // 일주일

    // jwt 토큰 생성
    public static String generateToken(Authentication authentication){

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION_MS);

        return Jwts.builder()
            .setSubject((String) authentication.getPrincipal()) // 사용자
            .setIssuedAt(new Date()) // 현재 시간 기반으로 생성
            .setExpiration(expiryDate) // 만료 시간 세팅
            .signWith(SignatureAlgorithm.HS512, JWT_SECRET) // 사용할 암호화 알고리즘, signature에 들어갈 secret 값 세팅
            .compact();
    }

    // jwt 토큰에서 아이디 추출
    public static String getUserIdFromJWT(String token){
        Claims claims = Jwts.parser() // Claims는 JWT의 body이고 JWT 생성자가 JWT를 받는이들에게 제시하기 바라는 정보를 포함한다.
            .setSigningKey(JWT_SECRET)
            .parseClaimsJws(token)
            .getBody();

        return claims.getSubject();
    }

    // jwt 토큰 유효성 검사
    public static boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex){
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex){
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex){
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex){
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex){
            log.error("JWT claims string is empty");
        }

        return false;
    }

}
