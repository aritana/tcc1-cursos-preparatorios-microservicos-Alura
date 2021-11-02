package br.com.alura.forum.config.security;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceLocal {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();
        Date dateExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("Api Forum Alura")
                .setSubject(logado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dateExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValido(String token) {

        try {
            Jwts.parser()
                    .setSigningKey(this.secret).parseClaimsJws(token);//devolve um objeto
            return true;
        } catch (Exception e) {//invalido ou nulo
            return false;
        }

    }

    public Long getIdUsuario(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(this.secret).parseClaimsJws(token).getBody();//devolve um objeto
        return Long.parseLong(claims.getSubject());
    }
}
