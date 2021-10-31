package br.com.alura.forum.config.security;

import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AutenticacaoService implements UserDetailsService {
    //o formulario irá buscar essa classe para autenticacao
    //a senha ele fara isso em memoria. Precismos consultar a senha no bd

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      Optional<Usuario> usuario = repository.findByEmail(username);
      if(usuario.isPresent()){
       return usuario.get();
      }
       throw new UsernameNotFoundException("Dados Inválidos");
    }
}
