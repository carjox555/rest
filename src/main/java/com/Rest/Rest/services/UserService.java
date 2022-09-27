package com.Rest.Rest.services;

import com.Rest.Rest.models.Usuario;
import com.Rest.Rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service              //Objeto para registrar en el beans
public class UserService {

    @Autowired
    private UserRepository usuarioRepository;

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }
    public Usuario getUsuario(String id) throws Exception {
        Optional<Usuario> usuarioOptinal =usuarioRepository.findById(id);
        if(usuarioOptinal.isPresent()){
            return usuarioOptinal.get();
        }else{
            throw new Exception("Usuario no Existe");
        }
    }
}

