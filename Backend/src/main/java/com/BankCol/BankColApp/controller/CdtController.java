package com.BankCol.BankColApp.controller;

import com.BankCol.BankColApp.domain.Cdt;
import com.BankCol.BankColApp.dto.CdtDTO;
import com.BankCol.BankColApp.dto.ConsignacionDTO;
import com.BankCol.BankColApp.mapper.CdtMapper;
import com.BankCol.BankColApp.mapper.ConsignacionMapper;
import com.BankCol.BankColApp.repository.CdtRepository;
import com.BankCol.BankColApp.service.CdtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Cdt> obtenerTodos(){
        List<Cdt> cdts = cdtRepository.findAll();
        return cdts;
    }

    @GetMapping("/porNumeroCdt/{numeroCdt}")
    public ResponseEntity<CdtDTO> buscarPorNumero(@PathVariable Integer numeroCdt) throws Exception{
        Cdt cdt = cdtRepository.findByNumero(numeroCdt);

        if(cdt != null) {
            CdtDTO cdtDTO = CdtMapper.domainToDto(cdt);
            return new ResponseEntity<>(cdtDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<CdtDTO>> buscarTodos(){
        return new ResponseEntity<>(cdtService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/porNumero/{numero}")
    public ResponseEntity<CdtDTO> buscarPorCodigo(@PathVariable Integer numero) throws Exception{
        Cdt cdt = cdtRepository.findByNumero(numero);

        if(cdt != null) {
            CdtDTO cdtDTO = CdtMapper.domainToDto(cdt);
            return new ResponseEntity<>(cdtDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<CdtDTO> guardarCdt(@RequestBody CdtDTO cdtDTO) throws Exception{
        CdtDTO cdtDTO1 = cdtService.guardarNuevoCdt(cdtDTO);
        return new ResponseEntity<>(cdtDTO1, HttpStatus.OK);
    }


}
