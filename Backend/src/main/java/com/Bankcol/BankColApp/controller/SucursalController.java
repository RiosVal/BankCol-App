package com.Bankcol.BankColApp.controller;

import com.Bankcol.BankColApp.domain.Sucursal;
import com.Bankcol.BankColApp.dto.SucursalDTO;
import com.Bankcol.BankColApp.repository.SucursalRepository;
import com.Bankcol.BankColApp.service.SucursalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
    private final SucursalRepository sucursalRepository;
    private final SucursalService sucursalService;

    public SucursalController(SucursalRepository sucursalRepository, SucursalService sucursalService) {
        this.sucursalRepository = sucursalRepository;
        this.sucursalService = sucursalService;
    }


    @GetMapping("/validar")
    public String validarController(){
        return "Controlador correcto";
    }

    @GetMapping("/obtenerTodos")
    public List<Sucursal> obtenerTodos() {
        List<Sucursal> sucursals = sucursalRepository.findAll();
        return sucursals;
    }

    @PostMapping("/guardar")
    public ResponseEntity<SucursalDTO> guardarSucursal(@RequestBody SucursalDTO sucursalDTO) throws Exception {
        SucursalDTO sucursalDTO1 = sucursalService.guardarNuevaSucursal(sucursalDTO);
        return new ResponseEntity<>(sucursalDTO1, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Sucursal getSucursal(@PathVariable ("id") Integer id){
        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        if(sucursal.isPresent()){
            return sucursal.get();
        }else{
            return null;
        }
    }

    @GetMapping("/eliminar/{id}")
    public void eliminar(Integer id){
        sucursalRepository.deleteById(id);
    }


    public Sucursal editar(@PathVariable ("id") Long id , Sucursal sucursal) {
        Optional<Sucursal> sucursal1 = sucursalRepository.findById(Math.toIntExact(id));
        if (sucursal1.isPresent()) {
            Sucursal sucursal2 = sucursal1.get();
            sucursal2.setDireccion(sucursal1.get().getDireccion());
            sucursal2.setTelefono(sucursal1.get().getTelefono());
            sucursal2.setCiudad(sucursal1.get().getCiudad());
            return sucursalRepository.save(sucursal2);
        }else{
            return null;
        }

    }
}