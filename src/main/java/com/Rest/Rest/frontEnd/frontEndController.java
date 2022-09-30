package com.Rest.Rest.frontEnd;

import com.Rest.Rest.models.Usuario;
import com.Rest.Rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class frontEndController {
    @Autowired
    UserService usuarioService;

    @GetMapping("/")
    public String getIndex(){
    return "index";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("formUsuario", new Usuario());
    return "login";
    }
    @GetMapping("/welcome")
    public String getWelcome(Model model){
       model.addAttribute("usuarios",usuarioService.getUsuarios());
        return "welcome";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("formUsuario") Usuario usuario){
        System.out.println(usuario);
        return "redirect:/welcome";
    }
}
