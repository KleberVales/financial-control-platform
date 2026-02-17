package com.financial.financialcontrol.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // ⚠️ Em produção usar variável de ambiente
    private final String SECRET = "minha-chave-super-secreta-para-jwt-que-deve-ter-pelo-menos-256-bits";

    private final long EXPIRATION = 1000 * 60 * 60; // 1 hora

    private final SecretKey secretKey = Keys.hmacShaKeyFor(SECRET.getBytes());

    // 🔹 Gerar token
    public String generateToken(String userId) {

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION);

        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    // 🔹 Extrair userId
    public String getUserId(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // 🔹 Validar token
    public boolean validateToken(String token) {

        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);

            return true;

        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }
}

