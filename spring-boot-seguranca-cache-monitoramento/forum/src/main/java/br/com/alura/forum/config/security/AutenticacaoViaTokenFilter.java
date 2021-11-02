package br.com.alura.forum.config.security;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;//filtro chamado uma unica vez a cada req

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {
    //em filtros nao ha como fazer injecao de dependencias.

    private TokenServiceLocal tokenServiceLocal;
    private UsuarioRepository usuarioRepository;

    public AutenticacaoViaTokenFilter(TokenServiceLocal tokenServiceLocal,UsuarioRepository usuarioRepository) {
        this.tokenServiceLocal = tokenServiceLocal;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//pega token antes de chegar no controller e verificar se ta ok
//precisa declarar esse filtro na classe de configuracao

        String token = recuperarToken(httpServletRequest);
        boolean valido = tokenServiceLocal.isTokenValido(token);
        if(valido){
            autenticarCliente(token);
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private void autenticarCliente( String token) {
        Long idUsuario = tokenServiceLocal.getIdUsuario(token);
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recuperarToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return  null;
        };
        return token.substring(7,token.length());
    }


}
