package com.Bankcol.BankColApp.controller;

import com.Bankcol.BankColApp.domain.Sucursal;
import com.Bankcol.BankColApp.repository.SucursalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
    private final SucursalRepository sucursalRepository;

    public SucursalController(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }


    @GetMapping("/validar")
    public String validarController(){
        return "Controlador correcto";
    }

    @GetMapping("/obtenerTodos")
    public List<Sucursal> obtenerTodos() {
        List<Sucursal> sucursals = sucursalRepository.findAll();
        return sucursals;
    }
}