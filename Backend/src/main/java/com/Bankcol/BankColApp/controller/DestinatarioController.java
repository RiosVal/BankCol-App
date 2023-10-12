package com.Bankcol.BankColApp.controller;

import com.Bankcol.BankColApp.domain.Destinatario;
import com.Bankcol.BankColApp.repository.DestinatarioRepository;
import com.Bankcol.BankColApp.service.DestinatarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/destinatario")
public class DestinatarioController {
    private final DestinatarioRepository destinatarioRepository;
    private final DestinatarioService  destinatarioService;

    public DestinatarioController(DestinatarioRepository destinatarioRepository, DestinatarioService destinatarioService) {
        this.destinatarioRepository = destinatarioRepository;
        this.destinatarioService = destinatarioService;
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
