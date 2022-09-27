package com.Rest.Rest.controler;

import com.Rest.Rest.models.Usuario;
import com.Rest.Rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController            //Trabajar con Json
public class UserControler {

    @Autowired
    private UserService usuarioService;

    @GetMapping("/usuarios")
    //Responde con un Json
    public ResponseEntity<List<Usuario>>getUsuario(){
        return new ResponseEntity<List<Usuario>>(
                usuarioService.getUsuarios(),
                HttpStatus.OK
        );
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Object>getUsuario(@PathVariable String id){

        try {
            Usuario  usuario = usuarioService.getUsuario(id);
            return new ResponseEntity<>(usuario,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/usuario")
    public ResponseEntity<Object>getUsuarios(@RequestParam String id){
        try {
            Usuario  usuario = usuarioService.getUsuario(id);
            return new ResponseEntity<>(usuario,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
