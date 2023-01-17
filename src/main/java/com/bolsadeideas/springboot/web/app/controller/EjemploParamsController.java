package com.bolsadeideas.springboot.web.app.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "params/index";
    }

    @GetMapping("/string")
    public String params(@RequestParam(value = "texto", required = false, defaultValue = "hsdfhsdf") String texto, Model model) {
        model.addAttribute("resultado", "El texto enviado es : " + texto);
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String params(@RequestParam String saludo, @RequestParam int numero, Model model) {
        model.addAttribute("resultado", "El texto enviado es : " + saludo + " y el numero es: " + numero);
        return "params/ver";
    }

    @GetMapping("/mix-params-request")
    public String params(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        boolean soltero = Boolean.parseBoolean(request.getParameter("soltero"));
        try {
            numero = Integer.parseInt(request.getParameter("numero"));

        } catch (NumberFormatException e) {
            numero = 0;
        }
        model.addAttribute("resultado", "El texto enviado es : " + saludo + " y el numero es: " + numero + ", es soltero?. " + soltero);
        return "params/ver";
    }
}
