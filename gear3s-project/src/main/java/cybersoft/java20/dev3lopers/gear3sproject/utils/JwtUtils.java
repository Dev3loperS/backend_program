package cybersoft.java20.dev3lopers.gear3sproject.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;


@Component
public class JwtUtils {
    // Cài đặt thời hạn cho token (ms)
    private long expiryTime = 8*60*60*1000;   // 8 tiếng

    @Value("${jwt.privateKey}")
    private String privateKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);

    public String generateToken(String userName){
        Date date = new Date();
        long currentDate = date.getTime() + expiryTime;
        Date expiryDate = new Date(currentDate);

        SecretKey key = Keys.hmacShaKeyFor(privateKey.getBytes());
        String jwt = Jwts.builder()
                    .setSubject(userName)
                    .setIssuedAt(date)
                    .setExpiration(expiryDate)
                    .signWith(key)
                    .compact();
        LOGGER.info("Token has been generated by '{}' - Token: {}",userName,jwt);

        return jwt;
    }

    public boolean verifyToken(String token){
        try {
            SecretKey key = Keys.hmacShaKeyFor(privateKey.getBytes());
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            LOGGER.error("Invalid JWT token: {}",e.getMessage());
        } catch (ExpiredJwtException e) {
            LOGGER.error("JWT token is expired: {}",e.getMessage());
        } catch (UnsupportedJwtException e) {
            LOGGER.error("JWT token is unsupported: {}",e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.error("JWT claims string is empty: {}",e.getMessage());
        } catch (SignatureException e) {
            LOGGER.error("Invalid JWT signature: {}",e.getMessage());
        }

        return false;
    }

    public String getSubjectFromToken(String token){
        try {
            SecretKey key = Keys.hmacShaKeyFor(privateKey.getBytes());
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e){
            LOGGER.error("Can not get subject from jwt token: {}",e.getMessage());
            return null;
        }
    }


}
