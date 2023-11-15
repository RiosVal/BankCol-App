package com.Bankcol.BankColApp.controller;

import com.Bankcol.BankColApp.domain.Cliente;
import com.Bankcol.BankColApp.dto.CdtDTO;
import com.Bankcol.BankColApp.dto.ClienteDTO;
import com.Bankcol.BankColApp.repository.ClienteRepository;
import com.Bankcol.BankColApp.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;

    public ClienteController(ClienteRepository clienteRepository, ClienteService clienteService) {
        this.clienteRepository = clienteRepository;
        this.clienteService = clienteService;
    }

    @GetMapping("/validar")
    public String validarController(){
        return "Controlador correcto";
    }


    //Obtener todos los clientes
    @GetMapping("/buscarTodos")
    public ResponseEntity<List<CdtDTO>> buscarTodos() {
        return new ResponseEntity<>(clienteService.buscarTodos(), HttpStatus.OK);
    }

    //Guardar cliente
    @PostMapping("/guardar")
    public ResponseEntity<ClienteDTO> guardarCliente(@RequestBody ClienteDTO clienteDTO) throws Exception {
        ClienteDTO clienteDTO1 = clienteService.guardarNuevoCliente(clienteDTO);
        return new ResponseEntity<>(clienteDTO1, HttpStatus.OK);
    }

    //Eliminar cliente por id
    @GetMapping("/clientes/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id){
        clienteRepository.deleteById(Math.toIntExact(id));
        return ResponseEntity.ok().build();
    }


    //Editar cliente
    @PutMapping("/clientes/editar/{id}")
    public Cliente editar(@PathVariable("id") Long id, Cliente cliente){
        Optional<Cliente> cliente1 = clienteRepository.findById(Math.toIntExact(id));
        if(cliente1.isPresent()){
            Cliente cliente2 = cliente1.get();
            cliente2.setNombre(cliente.getNombre());
            cliente2.setApellido(cliente.getApellido());
            cliente2.setCedula(cliente.getCedula());
            cliente2.setCorreo(cliente.getCorreo());
            cliente2.setUsuario(cliente.getUsuario());
            cliente2.setContra(cliente.getContra());
            clienteRepository.save(cliente2);
            return cliente2;
        }else{
            return null;
        }
    }


    //Buscar cliente por cedula
    @GetMapping("/clientes/buscarcedula/{cedula}")
    public Cliente buscarcedula(@PathVariable("cedula") Integer cedula){
        List<Cliente> clientes = clienteRepository.findAll();
        for(Cliente cliente : clientes){
            if(cliente.getCedula().equals(cedula)){
                return cliente;
            }
        }
        return null;
    }

}