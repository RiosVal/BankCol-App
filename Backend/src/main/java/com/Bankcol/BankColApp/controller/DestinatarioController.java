package com.Bankcol.BankColApp.controller;

import com.Bankcol.BankColApp.domain.Destinatario;
import com.Bankcol.BankColApp.repository.DestinatarioRepository;
import com.Bankcol.BankColApp.service.DestinatarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/destinatario")
public class DestinatarioController {
    private final DestinatarioRepository destinatarioRepository;
    private final DestinatarioService destinatarioService;

    public DestinatarioController(DestinatarioRepository destinatarioRepository, DestinatarioService destinatarioService) {
        this.destinatarioRepository = destinatarioRepository;
        this.destinatarioService = destinatarioService;
    }

    @GetMapping("/validar")
    public String validarController() {
        return "Controlador correcto";
    }

    @GetMapping("/obtenerTodos")
    public List<Destinatario> obtenerTodos() {
        List<Destinatario> destinatarios = destinatarioRepository.findAll();
        return destinatarios;
    }

    @GetMapping("/destinatario/{id}")
    public Destinatario getDestinatario(@PathVariable("id") Integer id) {
        Optional<Destinatario> destinatario = destinatarioRepository.findById(id);
        if (destinatario.isPresent()) {
            return destinatario.get();
        } else {
            return null;
        }
    }

    @GetMapping("/destinatario/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        destinatarioRepository.deleteById(id);
    }

    @GetMapping("/destinatario/editar/{id}")
    public Destinatario editar(@PathVariable("id") Long id, Destinatario destinatario) {
        Optional<Destinatario> destinatario1 = destinatarioRepository.findById(Math.toIntExact(id));
        if (destinatario1.isPresent()) {
            Destinatario destinatario2 = destinatario1.get();
            destinatario2.setBanco_destinatario(destinatario.getBanco_destinatario());
            destinatario2.setCedula_destinatario(destinatario.getCedula_destinatario());
            destinatario2.setNombre_destinatario(destinatario.getNombre_destinatario());
            destinatario2.setApellido_destinatario(destinatario.getApellido_destinatario());
            destinatario2.setNumcuenta_destinatario(destinatario.getNumcuenta_destinatario());
            destinatario2.setCuenta_favorita(destinatario.getCuenta_favorita());
            return destinatarioRepository.save(destinatario2);
        } else {
            return null;
        }

    }
}
