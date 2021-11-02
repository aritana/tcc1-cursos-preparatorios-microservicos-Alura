package br.com.alura.forum.config.security;

import br.com.alura.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration //beans
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    //sobrescrever 3 méthodos da interface WebSecurityConfiguerAdapter
    //configuracao de autenticação: acesso, logins e etc.
    @Autowired
    private TokenServiceLocal tokenServiceLocal;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Bean //para injetar no nosso controller. Pois nao é feita a injecao dependcia automaticamente
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());//para infomar classe de autentificação
    }

    //configuracao de autorizacao: url, perfil de acesso
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/topicos").permitAll()
                .antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()//Desabilita verificacao desse tipo de ataque de sessao
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//desabilita sessao
                .and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenServiceLocal,usuarioRepository), UsernamePasswordAuthenticationFilter.class)//colocando meu filtro para rodar antes antes do principal
        ;
    }

    //configuracao de recursos estáticos(js, css, imagens, etc)
    @Override
    public void configure(WebSecurity web) throws Exception {
    }

}
