package com.Bankcol.BankColApp.controller;

import com.Bankcol.BankColApp.domain.Sucursal;
import com.Bankcol.BankColApp.dto.SucursalDTO;
import com.Bankcol.BankColApp.repository.SucursalRepository;
import com.Bankcol.BankColApp.service.SucursalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
    private final SucursalRepository sucursalRepository;
    private final SucursalService sucursalService;

    public SucursalController(SucursalRepository sucursalRepository, SucursalService sucursalService) {
        this.sucursalRepository = sucursalRepository;
        this.sucursalService = sucursalService;
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

    @PostMapping("/guardar")
    public ResponseEntity<SucursalDTO> guardarSucursal(@RequestBody SucursalDTO sucursalDTO) throws Exception {
        SucursalDTO sucursalDTO1 = sucursalService.guardarNuevaSucursal(sucursalDTO);
        return new ResponseEntity<>(sucursalDTO1, HttpStatus.OK);
    }
}