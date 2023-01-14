package com.bolsadeideas.springboot.web.app.controller;


import com.bolsadeideas.springboot.web.app.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/app")
public class IndexController {
    @GetMapping({"/index", "/home", "/"})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring framework con Model!");
        return "index";
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setApellido("Gonzalez");
        usuario.setNombre("Luis");
        usuario.setEmail("Luis10amador@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "perfil del usuario: " + usuario.getNombre());
        return "perfil";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        List<Usuario> usuarios = Arrays.asList(new Usuario("Luis", "GFonzalez", "unixluisx@protonmail.ch"),
                new Usuario("Jose", "GFonzalez", "unixluisx@protonmail.ch"),
                new Usuario("L", "GFonzalez", "unixluisx@protonmail.ch"),
                new Usuario("L", "GFonzalez", "unixluisx@protonmail.ch"));


        model.addAttribute("titulo", "listado de usuarios");
        model.addAttribute("usuarios", usuarios);

        return "listar";
    }
}
