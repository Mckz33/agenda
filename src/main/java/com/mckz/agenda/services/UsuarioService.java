package com.mckz.agenda.services;

import com.mckz.agenda.models.UsuarioModel;
import com.mckz.agenda.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Optional<UsuarioModel> optUsuario = usuarioRepository.findByUsuario(usuario);

        if (optUsuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario não econtrado");
        }
        UsuarioModel user = optUsuario.get();
        return new User(user.getUsuario(), user.getSenha(), new ArrayList<>());
    }

    public List<UsuarioModel> getAll() {
        return usuarioRepository.findAll();
    }

    public UsuarioModel save(UsuarioModel usuarioModel) {
        usuarioModel.setSenha(passwordEncoder.encode(usuarioModel.getSenha()));
        return usuarioRepository.save(usuarioModel);
    }
}
