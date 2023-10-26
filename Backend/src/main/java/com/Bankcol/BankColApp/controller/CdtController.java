package com.Bankcol.BankColApp.controller;

import com.Bankcol.BankColApp.domain.Cdt;
import com.Bankcol.BankColApp.dto.CdtDTO;
import com.Bankcol.BankColApp.repository.CdtRepository;
import com.Bankcol.BankColApp.service.CdtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cdt")
public class CdtController {
    private final CdtService cdtService;
    private final CdtRepository cdtRepository;

    public CdtController(CdtService cdtService, CdtRepository cdtRepository) {
        this.cdtService = cdtService;
        this.cdtRepository = cdtRepository;
    }

    /*@GetMapping("/obtenerTodos")
    public List<Cdt> obtenerTodos() { return cdtRepository.findAll();}*/

    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<CdtDTO>> buscarTodos() {
        return new ResponseEntity<>(cdtService.buscarTodos(), HttpStatus.OK);
    }
    @PostMapping("/guardar")
    public ResponseEntity<CdtDTO> guardarCdt(@RequestBody CdtDTO cdtDTO) throws Exception {
        CdtDTO cdtDTO1 = cdtService.guardarNuevoCdt(cdtDTO);
        return new ResponseEntity<>(cdtDTO1, HttpStatus.OK);
    }
}
