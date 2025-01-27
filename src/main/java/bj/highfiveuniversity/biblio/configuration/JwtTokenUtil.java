package bj.highfiveuniversity.biblio.configuration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {
    @Value("${jwt.secret}")
    private String secret_key;
    @Value("${jwt.expiration}")
    private Long expiration ;

 // Méthode pour Récupérer le nom de  l'utilisateur
    public String getUsernameFromToken( String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token , Function<Claims,T> claimsResolver){
       final Claims claims = getAllClaimsFromToken(token);
       return claimsResolver.apply(claims) ;
    }
 // Méthode pour récupérer la date d'expiration 

 public Date getExpirationDateFromToken(String token){
    return getClaimFromToken(token, Claims::getExpiration);
 }

 private Claims getAllClaimsFromToken( String token ){
    return Jwts.parser()
    .setSigningKey(secret_key)
    .parseClaimsJws(token)
    .getBody();
 }
 // Méthode pour vérifier si le token est expiré 
private Boolean isTokenExpired(String token ){
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(new Date()) ;
}
 // Méthode pour générer un token à l'utilsateur 
 public String genrateToken(UserDetails userDetails){
    Map< String, Object > claims = new HashMap<>();
    return doGenerateToken(claims, userDetails.getUsername());
 }
 private String doGenerateToken(Map< String, Object > claims, String subject){
    return Jwts.builder()
    .setClaims(claims)
    .setSubject(subject)
    .setIssuedAt(new Date(System.currentTimeMillis()))
    .setExpiration(new  Date(System.currentTimeMillis()  + this.expiration) )
    .signWith(SignatureAlgorithm.HS512 , secret_key)
    .compact();
 }

 // Méthode pour valider le token 
 public Boolean validateToken(String token, UserDetails userDetails){
    final String username = getUsernameFromToken(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
 }
}
