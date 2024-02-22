package br.com.bradesco.kit.bff.webclient;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class CreateJWT {

    private static final String SECRET_KEY_TI = "1c9e6ee8-5ca9-47d8-b441-fd69921d7d92";
    private static final String SECRET_KEY_TU = "f37cc08a-b32e-4bd0-82a8-fad22a45a6e3";
    private static final String SECRET_KEY_TH = "a31841ac-2dfb-481d-90e0-cabdaa186bea";

    private static final long EXPIRATION_TIME = 360000;


    public String generateToken() {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY_TI.getBytes());

        Map<String, Object> claims = new HashMap<>();
        claims.put("ver", "2.0");
        claims.put("sub", "76845c3b-82f5-4c75-a1ab-010ab50ff667");
        claims.put("iss", "Bradesco Expresso");
        claims.put("aud", "/cartoes/aquisicao/parceiros/v1/login/sistema");
        claims.put("iat", System.currentTimeMillis() / 1000);
        claims.put("exp", (System.currentTimeMillis() / 1000) + EXPIRATION_TIME);
        claims.put("jti", UUID.randomUUID().toString());
        claims.put("usr", "0739709700016715141728013");
        claims.put("pla", "Cartoes Autorizador Openshift");
        claims.put("app", "Bradesco Expresso");

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }
}
