package com.Rest.Rest.services;

import com.Rest.Rest.models.MyUserDetails;
import com.Rest.Rest.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserService usuarioService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Usuario usuario=null;
        try {
            usuario=usuarioService.getUsuario(username);
            System.out.println(usuario);
        } catch (Exception e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
        return new MyUserDetails(usuario);
    }
}
