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

    //Obtener todos los CDTS
    @GetMapping(    "/obtenerTodos")
    public ResponseEntity<List<CdtDTO>> buscarTodos() {
        return new ResponseEntity<>(cdtService.buscarTodos(), HttpStatus.OK);
    }
    //Guardar CDT
    @PostMapping("/guardar")
    public ResponseEntity<CdtDTO> guardarCdt(@RequestBody CdtDTO cdtDTO) throws Exception {
        CdtDTO cdtDTO1 = cdtService.guardarNuevoCdt(cdtDTO);
        return new ResponseEntity<>(cdtDTO1, HttpStatus.OK);
    }


    //Obtener CDT por id (Deberia cambiar a por ejemplo nombre del cdt como logica de negocio)
    @GetMapping("/cdt/{id}")
    public Cdt getCdt(@PathVariable("id") Long id){
        Optional<Cdt> cdt = cdtRepository.findById(Math.toIntExact(id));
        if(cdt.isPresent()){
            return cdt.get();
        }else{
            return null;
        }
    }

    //Eliminar CDT por id
    @GetMapping("/cdt/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id){
        cdtRepository.deleteById(Math.toIntExact(id));
        return ResponseEntity.ok().build();
    }

    //editar cdt
    @PutMapping("/cdt/editar")
    public Cdt editar(@RequestBody CdtDTO cdtDTO) {
        Optional<Cdt> cdt1 = cdtRepository.findById(Math.toIntExact(cdtDTO.getId()));
        if (cdt1.isPresent()) {
            Cdt cdt2 = cdt1.get();
            cdt2.setFecha_inicio(cdt.getFecha_inicio());
            cdt2.setFecha_fin(cdt.getFecha_fin());
            cdt2.setTasa(cdt.getTasa());
            cdt2.setMonto_invertido(cdt.getMonto_invertido());
            cdt2.setMonto_final(cdt.getMonto_final());
            cdt2.setSucursal(cdt.getSucursal());
            cdt2.setEstadoCdt(cdt.getEstadoCdt());
            cdtRepository.save(cdt2);
            return cdt2;

        }else {
            return null;
        }
    }


}
