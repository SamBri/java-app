package com.app.security;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;

import com.sun.net.httpserver.AbstractJwtUtil;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.spec.SecretKeySpec;

public class MyApplicationJwtUtil extends AbstractJwtUtil {

    private final String secret = "sR3ugAly675HmC8n5ex8b1axEAI1ZH9WpaPV1hLUPSY08OOuBIn";

    private final long expiration = 3600000; // 1 hour in milliseconds

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    protected String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return extractClaim(token, claims->claims.getSubject());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, claims->claims.getExpiration());
    }

    protected <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    protected Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    protected Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    protected Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    
    public static void main(String[] args) {
        // Create a signing key (for HMAC-SHA algorithms)
        String secretString = "thisismyverysecretkeyforjwtsigning";
        Key key = new SecretKeySpec(secretString.getBytes(), SignatureAlgorithm.HS256.getJcaName());

        // Build the JWT
        String jwt = Jwts.builder()
                .setSubject("user123")
                .claim("role", "admin")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiration
                .signWith(key, SignatureAlgorithm.HS256)
                .compact(); // Finalize and compact the JWT

        System.out.println("Generated JWT: " + jwt);
    }
}