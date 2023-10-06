package com.Bankcol.BankColApp.controller;

import com.Bankcol.BankColApp.domain.Cliente;
import com.Bankcol.BankColApp.dto.ClienteDTO;
import com.Bankcol.BankColApp.repository.ClienteRepository;
import com.Bankcol.BankColApp.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;

    public ClienteController(ClienteRepository clienteRepository, ClienteService clienteService) {
        this.clienteRepository = clienteRepository;
        this.clienteService = clienteService;
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

    @PostMapping("/guardar")
    public ResponseEntity<ClienteDTO> guardarCliente(@RequestBody ClienteDTO clienteDTO) throws Exception {
        ClienteDTO clienteDTO1 = clienteService.guardarNuevoCliente(clienteDTO);
        return new ResponseEntity<>(clienteDTO1, HttpStatus.OK);
    }

}