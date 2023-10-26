package com.Bankcol.BankColApp.controller;

import com.Bankcol.BankColApp.domain.Transaccion;
import com.Bankcol.BankColApp.dto.TransaccionDTO;
import com.Bankcol.BankColApp.repository.TransaccionRepository;
import com.Bankcol.BankColApp.service.TransaccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Transaccion")
public class TransaccionController {

    private final TransaccionRepository transaccionRepository;

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionRepository transaccionRepository, TransaccionService transaccionService) {
        this.transaccionRepository = transaccionRepository;
        this.transaccionService = transaccionService;
    }


    @PostMapping("/guardar")
    public ResponseEntity<TransaccionDTO> guardarTransaccion(@RequestBody TransaccionDTO transaccionDTO) throws Exception {
        TransaccionDTO transaccionDTO1 = transaccionService.guardarNuevaTransaccion(transaccionDTO);
        return new ResponseEntity<>(transaccionDTO1, HttpStatus.OK);
    }

    @GetMapping("/transaccion/ver_todos")
    public List gettransaccion(){
        return transaccionRepository.findAll();
    }

    @GetMapping("/transaccion/{id}")
    public Transaccion gettransaccion(@PathVariable("id") Integer id){
        Optional<Transaccion> transaccion = transaccionRepository.findById(id);
        if(transaccion.isPresent()){
            return transaccion.get();
        }else{
            return null;
        }
    }

    @GetMapping("/transaccion/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        transaccionRepository.deleteById(id);
    }

    @GetMapping("/transaccion/editar/{id}")
    public Transaccion editar(@PathVariable ("id") Long id , Transaccion transaccion) {
        Optional<Transaccion> transaccion1 = transaccionRepository.findById(Math.toIntExact(id));
        if (transaccion1.isPresent()) {
            Transaccion transaccion2 = transaccion1.get();
            transaccion2.setTipo(transaccion1.get().getTipo());
            transaccion2.setFecha(transaccion1.get().getFecha());
            transaccion2.setMonto(transaccion1.get().getMonto());
            transaccion2.setDescripcion(transaccion1.get().getDescripcion());
            transaccion2.setCuenta(transaccion1.get().getCuenta());
            transaccion2.setDestinatario(transaccion1.get().getDestinatario());
            return transaccionRepository.save(transaccion2);
        }else{
            return null;
        }

    }


}
