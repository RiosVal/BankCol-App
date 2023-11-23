package com.BankCol.BankColApp.controller;

import com.BankCol.BankColApp.domain.Consignacion;
import com.BankCol.BankColApp.domain.Retiro;
import com.BankCol.BankColApp.dto.ConsignacionDTO;
import com.BankCol.BankColApp.dto.RetiroDTO;
import com.BankCol.BankColApp.mapper.ConsignacionMapper;
import com.BankCol.BankColApp.mapper.RetiroMapper;
import com.BankCol.BankColApp.repository.RetiroRepository;
import com.BankCol.BankColApp.service.RetiroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/retiro")
public class RetiroController {
    private final RetiroService retiroService;
    private final RetiroRepository retiroRepository;

    public RetiroController(RetiroService retiroService, RetiroRepository retiroRepository) {
        this.retiroService = retiroService;
        this.retiroRepository = retiroRepository;
    }

    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<RetiroDTO>> buscarTodos() {
        return new ResponseEntity<>(retiroService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/porCodigo/{codigo}")
    public ResponseEntity<RetiroDTO> buscarPorCodigo(@PathVariable String codigo) throws Exception{
        Retiro retiro = retiroRepository.findByCodigoRetiro(codigo);

        if(retiro != null) {
            RetiroDTO retiroDTO = RetiroMapper.domainToDto(retiro);
            return new ResponseEntity<>(retiroDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<RetiroDTO> guardarRetiro(@RequestBody RetiroDTO retiroDTO) throws Exception{
        RetiroDTO retiroDTO1 = retiroService.guardarNuevoRetiro(retiroDTO);
        return new ResponseEntity<>(retiroDTO1, HttpStatus.OK);
    }
}
