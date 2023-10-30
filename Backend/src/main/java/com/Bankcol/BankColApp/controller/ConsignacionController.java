package com.Bankcol.BankColApp.controller;

import com.Bankcol.BankColApp.domain.Cliente;
import com.Bankcol.BankColApp.domain.Consignacion;
import com.Bankcol.BankColApp.dto.ConsignacionDTO;
import com.Bankcol.BankColApp.repository.ConsignacionRepository;
import com.Bankcol.BankColApp.service.ConsignacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consignacion")
public class ConsignacionController {

   private final ConsignacionRepository consignacionRepository;


   private final ConsignacionService consignacionService;

    public ConsignacionController(ConsignacionService consignacionService, ConsignacionRepository consignacionRepository) {
        this.consignacionService = consignacionService;
        this.consignacionRepository = consignacionRepository;
    }


    //obtener todos las consignaciones
    @GetMapping("/obtenerTodos")
   public ResponseEntity<List<ConsignacionDTO>> buscartodos(){
        return new ResponseEntity<>(consignacionService.buscarTodos(), HttpStatus.OK);
    }

    //crear consigancion
    @PostMapping("/guardarConsinacion")
    public ResponseEntity<ConsignacionDTO> guardarConsignacion(@RequestBody ConsignacionDTO consignacionDTO) throws Exception{
        ConsignacionDTO consignacionDTO1 = consignacionService.guardarNuevaConsignacionn(consignacionDTO);
        return new ResponseEntity<>(consignacionDTO1,HttpStatus.OK);
    }

    //eliminar consignacion
    @GetMapping("/consigancion/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id){
        consignacionRepository.deleteById(Math.toIntExact(id));
        return ResponseEntity.ok().build();
    }



    //ediar consignacion
    @GetMapping("/consignacion/editar")
    public Consignacion editar(@PathVariable ("id") Long id, Consignacion consignacion){
        Optional<Consignacion> consignacion1 = consignacionRepository.findById(Math.toIntExact(id));
        if(consignacion1.isPresent()){
            Consignacion consignacion2 = consignacion1.get();
            consignacion2.setFecha(consignacion.getFecha());
            consignacion2.setMonto(consignacion.getMonto());
            consignacion2.setCliente(consignacion.getCliente());
            consignacionRepository.save(consignacion2);
            return consignacion2;
        }else{
            return null;
        }


    }



}
