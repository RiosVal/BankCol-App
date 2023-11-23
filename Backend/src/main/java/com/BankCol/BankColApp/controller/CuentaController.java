package com.BankCol.BankColApp.controller;

import com.BankCol.BankColApp.domain.Cuenta;
import com.BankCol.BankColApp.dto.ConsignacionDTO;
import com.BankCol.BankColApp.dto.CuentaDTO;
import com.BankCol.BankColApp.mapper.CuentaMapper;
import com.BankCol.BankColApp.repository.CuentaRepository;
import com.BankCol.BankColApp.service.CuentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    private final CuentaService cuentaService;
    private final CuentaRepository cuentaRepository;

    public CuentaController(CuentaService cuentaService, CuentaRepository cuentaRepository) {
        this.cuentaService = cuentaService;
        this.cuentaRepository = cuentaRepository;
    }

    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<CuentaDTO>> buscarTodos() {
        return new ResponseEntity<>(cuentaService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/porNumero/{numero}")
    public ResponseEntity<CuentaDTO> buscarPorCodigo(@PathVariable Integer numero) throws Exception{
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numero);

        if(cuenta != null) {
            CuentaDTO cuentaDTO = CuentaMapper.domainToDto(cuenta);
            return new ResponseEntity<>(cuentaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<CuentaDTO> guardarCuenta(@RequestBody CuentaDTO cuentaDTO) throws Exception{
        CuentaDTO cuentaDTO1 = cuentaService.guardarNuevaCuenta(cuentaDTO);
        return new ResponseEntity<>(cuentaDTO1, HttpStatus.OK);
    }
}
