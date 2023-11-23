package com.BankCol.BankColApp.controller;

import com.BankCol.BankColApp.domain.Cliente;
import com.BankCol.BankColApp.dto.ClienteDTO;
import com.BankCol.BankColApp.mapper.ClienteMapper;
import com.BankCol.BankColApp.repository.ClienteRepository;
import com.BankCol.BankColApp.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/obtenerTodos")
    public List<ClienteDTO> obtenerTodos() {
        List<ClienteDTO> clientes = clienteService.buscarTodos();
        return clientes;
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(clienteService.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping("/porCedula/{cedula}")
    public ResponseEntity<ClienteDTO> buscarPorCedula(@PathVariable Integer cedula) throws Exception {
        return new ResponseEntity<>(clienteService.buscarPorCedula(cedula), HttpStatus.OK);
    }

    @GetMapping("/porUsuario/{usuario}")
    public ResponseEntity<ClienteDTO> buscarPorUsuario(@PathVariable String usuario) throws Exception {
        return new ResponseEntity<>(clienteService.buscarPorUsuario(usuario), HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<ClienteDTO> guardarCliente(@RequestBody ClienteDTO clienteDTO) throws Exception{
        return new ResponseEntity<>(clienteService.guardarNuevoCliente(clienteDTO), HttpStatus.OK);
    }
}
