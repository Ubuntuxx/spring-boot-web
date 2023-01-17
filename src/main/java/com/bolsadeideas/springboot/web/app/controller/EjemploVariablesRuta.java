package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRuta {
    @GetMapping("/String/{texto}")
    public String variables(@PathVariable String texto, Model model) {
        model.addAttribute("titulo","Recibir parametros de la ruta (@Path variable)");
        model.addAttribute("resultado","El texto enviado en la ruta es: " + texto);
        return "variables/ver";
    }
}
