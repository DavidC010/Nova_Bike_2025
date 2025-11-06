package com.NovaBike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {

    @GetMapping("/login")
    public String mostrarLogin() {
        return "iniciarSesion/login"; // nombre del archivo login.html en templates
    }
}
