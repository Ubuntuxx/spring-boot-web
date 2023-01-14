package com.bolsadeideas.springboot.web.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/app")
public class IndexController {
    @GetMapping({"/index", "/home", "/"})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring framework con Model!");
        return "index";
    }
}
