package com.Rest.Rest.controler;

import com.Rest.Rest.models.UserResponse;
import com.Rest.Rest.models.Usuario;
import com.Rest.Rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller            //Trabajar con Json   @Controler -> espera con q se va a responder
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

    @PostMapping("/usuario")  //Objeto Response
    public ResponseEntity<UserResponse>postUsuaario(@RequestBody Usuario usuario){  //RequestBody -> espera un Json  asociado a usuario
    return new ResponseEntity<>(
            new UserResponse("Usuario creado Exitosamente",
                    usuarioService.saveUsuario(usuario))
                    ,HttpStatus.OK);
    }

    @PutMapping("/usuario")
    public ResponseEntity<UserResponse>putUsuario(@RequestBody Usuario usuario){
        return  new ResponseEntity<>(
                new UserResponse("Usuario Actualizado",usuarioService.putUsuario(usuario)),HttpStatus.OK);

    }

    @PatchMapping("/usuario/{id}")
    public ResponseEntity<UserResponse>patchUsuario(@RequestBody Usuario usuario,@PathVariable String id ){
        try {
            return  new ResponseEntity<>(
                    new UserResponse("Actualizacion Exitosa",usuarioService.patchUsuario(usuario,  id)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(
                    new UserResponse(e.getMessage(),null),
                            HttpStatus.OK);
        }

    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<UserResponse>delete(@PathVariable String id){
        return  new ResponseEntity<>(

                new UserResponse(usuarioService.delete(id),null),
                HttpStatus.OK);

    }


}
