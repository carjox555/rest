package com.Rest.Rest.frontEnd;

import com.Rest.Rest.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class frontEndController {
    @GetMapping("/")
    public String getIndex(){
    return "index";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("formUsuario", new Usuario());
    return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("formUsuario") Usuario usuario){
        System.out.println(usuario);
        return "redirect:/welcome";
    }
}
