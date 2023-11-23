package com.BankCol.BankColApp.controller;

import com.BankCol.BankColApp.domain.Destinatario;
import com.BankCol.BankColApp.dto.ClienteDTO;
import com.BankCol.BankColApp.dto.DestinatarioDTO;
import com.BankCol.BankColApp.mapper.DestinatarioMapper;
import com.BankCol.BankColApp.repository.DestinatarioRepository;
import com.BankCol.BankColApp.service.DestinatarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinatario")
public class DestinatarioController {
    private final DestinatarioService destinatarioService;

    public DestinatarioController(DestinatarioService destinatarioService) {
        this.destinatarioService = destinatarioService;
    }

    @GetMapping("/obtenerTodos")
    public List<DestinatarioDTO> obtenerTodos(){
        return destinatarioService.buscarTodos();
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<DestinatarioDTO> buscarPorId(@PathVariable Integer id) throws Exception{
        return new ResponseEntity<>(destinatarioService.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping("/porCedula/{cedula}")
    public ResponseEntity<DestinatarioDTO> buscarPorCedula(@PathVariable Integer cedula) throws Exception{
        return new ResponseEntity<>(destinatarioService.buscarPorCedula(cedula), HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<DestinatarioDTO> guardarDestinatario(@RequestBody DestinatarioDTO destinatarioDTO) throws Exception{
        DestinatarioDTO destinatarioDTO1 = destinatarioService.guardarNuevoDestinatario(destinatarioDTO);
        return new ResponseEntity<>(destinatarioDTO1, HttpStatus.OK);
    }
}
