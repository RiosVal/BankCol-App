package com.Bankcol.BankColApp.controller;


import com.Bankcol.BankColApp.dto.RetiroDTO;
import com.Bankcol.BankColApp.repository.CuentaRepository;
import com.Bankcol.BankColApp.service.RetiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpClient;
import java.util.List;

@RestController
@RequestMapping("/Retiro")
public class RetiroController {
    private final RetiroService retiroService;
    private final CuentaRepository cuentaRepository;

    public RetiroController(RetiroService retiroService, CuentaRepository cuentaRepository) {
        this.retiroService = retiroService;
        this.cuentaRepository = cuentaRepository;
    }

    //Obtener todos los retiros
    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<RetiroDTO>> buscarTodos(){
        return new ResponseEntity<>(retiroService.buscarTodos(), HttpStatus.OK);
    }
}
