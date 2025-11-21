package com.NovaBike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {

    @GetMapping("/perfil")
    public String mostrarPerfil() {
        return "infoPerfil/perfil"; // nombre del archivo html en templates
    }
}
