package com.BankCol.BankColApp.controller;

import com.BankCol.BankColApp.domain.TipoCuenta;
import com.BankCol.BankColApp.dto.TipoCuentaDTO;
import com.BankCol.BankColApp.mapper.TipoCuentaMapper;
import com.BankCol.BankColApp.repository.TipoCuentaRepository;
import com.BankCol.BankColApp.service.TipoCuentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoCuenta")
public class TipoCuentaController {
    private final TipoCuentaRepository tipoCuentaRepository;
    private final TipoCuentaService tipoCuentaService;

    public TipoCuentaController(TipoCuentaRepository tipoCuentaRepository, TipoCuentaService tipoCuentaService) {
        this.tipoCuentaRepository = tipoCuentaRepository;
        this.tipoCuentaService = tipoCuentaService;
    }

    @GetMapping("/obtenerTodos")
    public List<TipoCuentaDTO> obtenerTodos(){
        return tipoCuentaService.buscarTodos();
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<TipoCuentaDTO> buscarPorId(@PathVariable Integer id) throws Exception{
        return new ResponseEntity<>(tipoCuentaService.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping("/porDescripcion/{descripcion}") //No funciona porque descripcion tiene espacios
    public ResponseEntity<TipoCuentaDTO> buscarPorDescripcion(@PathVariable String descripcion) throws Exception{
        return new ResponseEntity<>(tipoCuentaService.buscarPorDescripcion(descripcion), HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<TipoCuentaDTO> guardarTipoCuenta(@RequestBody TipoCuentaDTO tipoCuentaDTO) throws Exception{
        TipoCuentaDTO tipoCuentaDTO1 = tipoCuentaService.guardarNuevoTipoCuenta(tipoCuentaDTO);
        return new ResponseEntity<>(tipoCuentaDTO1, HttpStatus.OK);
    }

}
