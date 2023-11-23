package com.BankCol.BankColApp.controller;

import com.BankCol.BankColApp.domain.Sucursal;
import com.BankCol.BankColApp.dto.SucursalDTO;
import com.BankCol.BankColApp.mapper.SucursalMapper;
import com.BankCol.BankColApp.repository.SucursalRepository;
import com.BankCol.BankColApp.service.SucursalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
    private final SucursalRepository sucursalRepository;
    private final SucursalService sucursalService;

    public SucursalController(SucursalRepository sucursalRepository, SucursalService sucursalService) {
        this.sucursalRepository = sucursalRepository;
        this.sucursalService = sucursalService;
    }

    @GetMapping("/obtenerTodos")
    public List<SucursalDTO> obtenerTodos(){
        return sucursalService.buscarTodos();
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<SucursalDTO> buscarPorId(@PathVariable Integer id) throws Exception{
        return new ResponseEntity<>(sucursalService.buscarPorId(id), HttpStatus.OK);
    }

    /*@GetMapping("/porDireccion/{direccion}") //No funciona porque la direccion tiene espacios en blanco
    public ResponseEntity<SucursalDTO> buscarPorDireccion(@PathVariable String direccion) throws Exception{
        Sucursal sucursal = sucursalRepository.findByDireccion(direccion.trim());

        if(sucursal != null){
            SucursalDTO sucursalDTO = SucursalMapper.domainToDto(sucursal);
            return new ResponseEntity<>(sucursalDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @PostMapping("/guardar")
    public ResponseEntity<SucursalDTO> guardarSucursal(@RequestBody SucursalDTO sucursalDTO) throws Exception{
        SucursalDTO sucursalDTO1 = sucursalService.guardarNuevaSucursal(sucursalDTO);
        return new ResponseEntity<>(sucursalDTO1, HttpStatus.OK);
    }

}
