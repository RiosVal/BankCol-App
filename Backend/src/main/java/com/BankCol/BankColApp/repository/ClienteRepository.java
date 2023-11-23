package com.BankCol.BankColApp.repository;

import com.BankCol.BankColApp.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByCedula(Integer cedula);  //Para GetMapping
    Cliente findByUsuario(String usuario);  //Para GetMapping

    Optional<Cliente> findClienteByCedula(Integer cedula);  //Para validaciones de PostMapping
}
