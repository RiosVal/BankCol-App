package com.Bankcol.BankColApp.controller;

import com.Bankcol.BankColApp.domain.TipoCuenta;
import com.Bankcol.BankColApp.dto.TipoCuentaDTO;
import com.Bankcol.BankColApp.mapper.TipoCuentaMapper;
import com.Bankcol.BankColApp.repository.TipoCuentaRepository;
import com.Bankcol.BankColApp.service.TipoCuentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoCuenta")
public class TipoCuentaController {
    private final TipoCuentaService tipoCuentaService;
    private final TipoCuentaRepository tipoCuentaRepository;

    public TipoCuentaController(TipoCuentaService tipoCuentaService, TipoCuentaRepository tipoCuentaRepository) {
        this.tipoCuentaService = tipoCuentaService;
        this.tipoCuentaRepository = tipoCuentaRepository;
    }


    @GetMapping("/validar")
    public String validarController(){
        return "Controlador correcto";
    }

    @GetMapping("/obtenerTodos")
    public List<TipoCuenta> obtenerTodos() {return tipoCuentaRepository.findAll();}

    @PostMapping("/guardar")
    public ResponseEntity<TipoCuentaDTO> guardarTipoCuenta(@RequestBody TipoCuentaDTO tipoCuentaDTO) throws Exception {
        TipoCuentaDTO tipoCuentaDTO1 = tipoCuentaService.guardarNuevoTipoCuenta(tipoCuentaDTO);
        return new ResponseEntity<>(tipoCuentaDTO1, HttpStatus.OK);
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<TipoCuentaDTO> buscarPorId(@PathVariable Integer id) throws Exception {
        TipoCuenta tipoCuenta = tipoCuentaRepository.getReferenceById((id));
        TipoCuentaDTO tipoCuentaDTO = TipoCuentaMapper.domainToDto((tipoCuenta));
        return new ResponseEntity<>(tipoCuentaDTO, HttpStatus.OK);
    }
}