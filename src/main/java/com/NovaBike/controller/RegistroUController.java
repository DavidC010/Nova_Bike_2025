package com.NovaBike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroUController {
    
    @GetMapping("/registro")
    public String creacionUser() {
        return "crearUsuario/registro"; // nombre del archivo registro.html en templates
    }
    
    //falta postmapping para redirigir al hacer la cuenta
}