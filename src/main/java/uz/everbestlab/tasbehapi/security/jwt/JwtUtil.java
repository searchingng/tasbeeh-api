package uz.everbestlab.tasbehapi.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import uz.everbestlab.tasbehapi.entity.User;

import java.util.Date;

@Component
public class JwtUtil {

    private static final String JWT_SECRET = "TASBEH-API";
    private static final Long EXPIRATION_TIME = Long.valueOf(1000 * 60 * 60 * 24 * 365);

    public String generateJwtToken(Long id){
        Date issued = new Date();
        Date expired = new Date(issued.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(String.valueOf(id))
                .setIssuedAt(issued)
                .setExpiration(expired)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String parseJwt(String jwt){
        Claims claims =  Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(jwt)
                .getBody();

        return claims.getSubject();
    }

}
