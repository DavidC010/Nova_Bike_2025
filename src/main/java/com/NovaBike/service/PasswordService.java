
package com.NovaBike.service;

import org.springframework.stereotype.Service;

@Service

public class PasswordService {
    public void enviarCorreoRecuperacion(String email){
        System.out.println("Solicitud de recuperación de contraseña para: "+ email);
        
        //Falta generar token para enviarse por correo
        //Se usara JavaMailSender
    }
    
}
