
package com.NovaBike.controller;

import com.NovaBike.service.PasswordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    // Muestra la página de "olvidé mi contraseña"
    @GetMapping("/forgot-password")
    public String mostrarFormulario() {
        return "forgot-password";
    }

    // Procesa el formulario
    @PostMapping("/forgot-password")
    public String procesarSolicitud(@RequestParam("email") String email) {
        passwordService.enviarCorreoRecuperacion(email);
        return "redirect:/login?success";
    }
}



