package com.Tecnicas.BancoApp.controller;

import com.Tecnicas.BancoApp.domain.Cliente;
import com.Tecnicas.BancoApp.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/validar")
    public String validarController(){
        return "Controlador correcto";
    }

    @GetMapping("/obtenerTodos")
    public List<Cliente> obtenerTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }
}
