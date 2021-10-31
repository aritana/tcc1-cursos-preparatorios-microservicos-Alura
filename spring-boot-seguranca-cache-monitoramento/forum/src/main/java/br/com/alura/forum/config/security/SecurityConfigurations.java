package br.com.alura.forum.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration //beans
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    //sobrescrever 3 méthodos da interface WebSecurityConfiguerAdapter
    //configuracao de autenticação: acesso, logins e etc.

    @Autowired
    private AutenticacaoService autenticacaoService;

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
                .anyRequest().authenticated()
                .and().csrf().disable()//Desabilita verificacao desse tipo de ataque de sessao
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//desabilita sessao
    }

    //configuracao de recursos estáticos(js, css, imagens, etc)
    @Override
    public void configure(WebSecurity web) throws Exception {
    }

}
