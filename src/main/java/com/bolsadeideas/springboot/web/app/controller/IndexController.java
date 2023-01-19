package com.bolsadeideas.springboot.web.app.controller;


import com.bolsadeideas.springboot.web.app.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/app")
public class IndexController {
    @Value("${texto.indexcontroller.index.titulo}")
    private String textIndex;
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textPerfil;
    @Value("${texto.indexcontroller.listar.titulo}")
    private String textListar;

    @GetMapping({"/index", "/home", "/"})
    public String index(Model model) {
        model.addAttribute("titulo", textIndex);
        return "index";
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setApellido("Gonzalez");
        usuario.setNombre("Luis");
        usuario.setEmail("Luis10amador@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textPerfil + usuario.getNombre());
        return "perfil";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", textListar);
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {
        List<Usuario> usuarios = Arrays.asList(new Usuario("Luis", "GFonzalez", "unixluisx@protonmail.ch"),
                new Usuario("Jose", "GFonzalez", "unixluisx@protonmail.ch"),
                new Usuario("L", "GFonzalez", "unixluisx@protonmail.ch"),
                new Usuario("L", "GFonzalez", "unixluisx@protonmail.ch"),
                new Usuario("Jose", "GFonzalez", "unixluisx@protonmail.ch"));
        return usuarios;
    }
}
