package com.BankCol.BankColApp.controller;

import com.BankCol.BankColApp.domain.EstadoCdt;
import com.BankCol.BankColApp.dto.EstadoCdtDTO;
import com.BankCol.BankColApp.mapper.EstadoCdtMapper;
import com.BankCol.BankColApp.repository.EstadoCdtRepository;
import com.BankCol.BankColApp.service.EstadoCdtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadoCdt")
public class EstadoCdtController {
    private final EstadoCdtService estadoCdtService;

    public EstadoCdtController(EstadoCdtService estadoCdtService) {
        this.estadoCdtService = estadoCdtService;
    }

    @GetMapping("/obtenerTodos")
    public List<EstadoCdtDTO> obtenerTodos(){
        return estadoCdtService.buscarTodos();
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<EstadoCdtDTO> buscarPorId(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(estadoCdtService.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping("/porDescripcion/{descripcion}")
    public ResponseEntity<EstadoCdtDTO> buscarPorDescripcion(@PathVariable String descripcion) throws Exception{
        return new ResponseEntity<>(estadoCdtService.buscarPorDescripcion(descripcion), HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<EstadoCdtDTO> guardarEstadoCdT(@RequestBody EstadoCdtDTO estadoCdtDTO) throws Exception{
        EstadoCdtDTO estadoCdtDTO1 = estadoCdtService.guardarNuevoEstadoCdt(estadoCdtDTO);
        return new ResponseEntity<>(estadoCdtDTO1, HttpStatus.OK);
    }

}
