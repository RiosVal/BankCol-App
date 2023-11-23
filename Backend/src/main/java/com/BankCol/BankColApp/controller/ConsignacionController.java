package com.BankCol.BankColApp.controller;

import com.BankCol.BankColApp.domain.Consignacion;
import com.BankCol.BankColApp.dto.ConsignacionDTO;
import com.BankCol.BankColApp.mapper.ConsignacionMapper;
import com.BankCol.BankColApp.repository.ConsignacionRepository;
import com.BankCol.BankColApp.service.ConsignacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consignacion")
public class ConsignacionController {
    private final ConsignacionService consignacionService;
    private final ConsignacionRepository consignacionRepository;

    public ConsignacionController(ConsignacionService consignacionService, ConsignacionRepository consignacionRepository) {
        this.consignacionService = consignacionService;
        this.consignacionRepository = consignacionRepository;
    }

    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<ConsignacionDTO>> buscarTodos() {
        return new ResponseEntity<>(consignacionService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/porCodigo/{codigo}")
    public ResponseEntity<ConsignacionDTO> buscarPorCodigo(@PathVariable String codigo) throws Exception{
        Consignacion consignacion = consignacionRepository.findByCodigoConsignacion(codigo);

        if(consignacion != null) {
            ConsignacionDTO consignacionDTO = ConsignacionMapper.domainToDto(consignacion);
            return new ResponseEntity<>(consignacionDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<ConsignacionDTO> guardarCOnsignacion(@RequestBody ConsignacionDTO consignacionDTO) throws Exception{
        ConsignacionDTO consignacionDTO1 = consignacionService.guardarNuevaConsignacion(consignacionDTO);
        return new ResponseEntity<>(consignacionDTO1, HttpStatus.OK);
    }

}
