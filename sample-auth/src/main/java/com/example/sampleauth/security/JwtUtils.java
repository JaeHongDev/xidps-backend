package com.example.sampleauth.security;

import com.example.sampleauth.security.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtUtils {

    private String jwtSecret = "secret";

    private final int jwtExpirationMs = 360000;

    public String generateJwtToken(UserDetailsImpl userPrincipal){
        return this.generateTokenFromUserId(userPrincipal.getUsername());

    }

    private String generateTokenFromUserId(String userId) {
        return Jwts.builder().setSubject(userId).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + this.jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, this.jwtSecret)
                .compact();
    }

    public String getUserIdFromJwtToken(String token){
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }


    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        }catch (SignatureException e){
            log.error("유효하지 않는 jwt 서명입니다: {}", e.getMessage());
        }catch(MalformedJwtException e){
            log.error("유효하지 않는 jwt 토큰입니다:{}", e.getMessage());
        }catch(ExpiredJwtException  e){
            log.error("만료된 jwt토큰입니다 :{}", e.getMessage());
        }catch(UnsupportedJwtException e){
            log.error("지원하지 않는 jwt 토큰입니다 : {}",e.getMessage());
        }catch (IllegalArgumentException e){
            log.error("jwt claims 문자열이 비어있습니다: {}",e.getMessage());
        }
        return false;
    }
}
