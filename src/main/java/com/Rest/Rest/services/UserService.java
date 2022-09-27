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
        Optional<Usuario> usuarioOptional =usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            return usuarioOptional.get();
        }else{
            throw new Exception("Usuario no Existe");
        }
    }
    public Usuario saveUsuario(Usuario usuario_param){
        return usuarioRepository.save(usuario_param);
    }

    public Usuario putUsuario(Usuario usuario_param){
        return  usuarioRepository.save(usuario_param);
    }

    public Usuario patchUsuario(Usuario usuario_param, String id ) throws Exception{
        try {
            Usuario usuarioBd =getUsuario(id);
            //Valida si existe el usuario que traiga los atributos y actualiza
            if(usuario_param.getNameUser()!=null){
                usuarioBd.setNamePeople(usuario_param.getNamePeople());
            } if(usuario_param.getPassword()!=null){
                usuarioBd.setPassword(usuario_param.getPassword());
            }
            return saveUsuario(usuarioBd);

        } catch (Exception e) {
            throw new Exception("Usuario no se actualizo porq no existe");
        }
    }

    public String delete(String id){
        usuarioRepository.deleteById(id);
        return "Usuario Eliminado";
    }
}

