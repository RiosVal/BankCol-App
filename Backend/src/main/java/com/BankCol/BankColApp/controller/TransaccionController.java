package com.BankCol.BankColApp.controller;

import com.BankCol.BankColApp.domain.Transaccion;
import com.BankCol.BankColApp.dto.TransaccionDTO;
import com.BankCol.BankColApp.mapper.TransaccionMapper;
import com.BankCol.BankColApp.repository.TransaccionRepository;
import com.BankCol.BankColApp.service.TransaccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {
    private final TransaccionService transaccionService;
    private final TransaccionRepository transaccionRepository;

    public TransaccionController(TransaccionService transaccionService, TransaccionRepository transaccionRepository) {
        this.transaccionService = transaccionService;
        this.transaccionRepository = transaccionRepository;
    }

    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<TransaccionDTO>> buscarTodos() {
        return new ResponseEntity<>(transaccionService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/porCodigo/{codigo}")
    public ResponseEntity<TransaccionDTO> buscarPorCodigo(@PathVariable String codigo) throws Exception{
        Transaccion transaccion = transaccionRepository.findByCodigoTransaccion(codigo);

        if(transaccion != null) {
            TransaccionDTO transaccionDTO = TransaccionMapper.domainToDto(transaccion);
            return new ResponseEntity<>(transaccionDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<TransaccionDTO> guardarTransaccion(@RequestBody TransaccionDTO transaccionDTO) throws Exception{
        TransaccionDTO transaccionDTO1 = transaccionService.guardarNuevaTransaccion(transaccionDTO);
        return new ResponseEntity<>(transaccionDTO1, HttpStatus.OK);
    }
}
