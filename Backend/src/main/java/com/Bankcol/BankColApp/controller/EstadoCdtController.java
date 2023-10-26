package com.Bankcol.BankColApp.controller;

import com.Bankcol.BankColApp.repository.EstadoCdtRepository;
import com.Bankcol.BankColApp.service.EstadoCdtService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estadoCdt")
public class EstadoCdtController {

    private final EstadoCdtService estadoCdtService;
    private final EstadoCdtRepository estadoCdtRepository;

    public EstadoCdtController(EstadoCdtService estadoCdtService, EstadoCdtRepository estadoCdtRepository) {
        this.estadoCdtService = estadoCdtService;
        this.estadoCdtRepository = estadoCdtRepository;
    }

    
}
