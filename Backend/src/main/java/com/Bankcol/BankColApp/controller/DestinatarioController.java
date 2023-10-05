package com.Tecnicas.BancoApp.controller;

import com.Tecnicas.BancoApp.domain.Destinatario;
import com.Tecnicas.BancoApp.repository.DestinatarioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/destinatario")
public class DestinatarioController {
    private final DestinatarioRepository destinatarioRepository;

    public DestinatarioController(DestinatarioRepository destinatarioRepository) {
        this.destinatarioRepository = destinatarioRepository;
    }

    @GetMapping("/validar")
    public String validarController(){
        return "Controlador correcto";
    }

    @GetMapping("/obtenerTodos")
    public List<Destinatario> obtenerTodos() {
        List<Destinatario> destinatarios = destinatarioRepository.findAll();
        return destinatarios;
    }
}
