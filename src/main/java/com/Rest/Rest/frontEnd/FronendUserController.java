package com.Rest.Rest.frontEnd;

import com.Rest.Rest.models.Usuario;
import com.Rest.Rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FronendUserController {

    //ir a BD y permitir modificar
    @Autowired
    UserService userService;

    @DeleteMapping("/delete/usuario/front/{id}")
    public String deleteUsuario(@PathVariable String id){
    userService.delete(id);
    return "redirect:/welcome";
    }

    @GetMapping("/usuario/add")
    public String getAddUsuario(Model model){
        model.addAttribute("newUsuario",new Usuario());
        return "add-user";
    }
}










































































































































