package com.Bankcol.BankColApp.controller;


import com.Bankcol.BankColApp.domain.Cuenta;
import com.Bankcol.BankColApp.dto.CuentaDTO;
import com.Bankcol.BankColApp.repository.CuentaRepository;
import com.Bankcol.BankColApp.service.CuentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<CuentaDTO>> buscartodos(){
        return new ResponseEntity<>(cuentaService.buscarTodos(), HttpStatus.OK);
    }
    @GetMapping("/ver-cuenta/{id}")
    public Cuenta getCuenta(Long id){
        Optional<Cuenta> cuenta = cuentaRepository.findById(Math.toIntExact(id));
        if(cuenta.isPresent()){
            return cuenta.get();
        }else{
            return null;
        }
    }

    @GetMapping("/eliminar-cuenta/{id}")
    public void eliminar(Long id) {
        cuentaRepository.deleteById(Math.toIntExact(id));

    }

    @GetMapping("/editar-cuenta")
    public Cuenta editar(@PathVariable("id") Long id, Cuenta cuenta){
        Optional<Cuenta> cuenta1 = cuentaRepository.findById(Math.toIntExact(id));
        if(cuenta1.isPresent()){
            Cuenta cuenta2 = cuenta1.get();
            cuenta2.setNumero_cuenta(cuenta.getNumero_cuenta());
            cuenta2.setMonto_disponible(cuenta.getMonto_disponible());
            cuenta2.setSucursal(cuenta.getSucursal());
            cuenta2.setTipoCuenta(cuenta.getTipoCuenta());
            cuenta2.setCliente(cuenta.getCliente());
            cuentaRepository.save(cuenta2);
            return cuenta2;
        }else{
            return null;
        }
    }

}
