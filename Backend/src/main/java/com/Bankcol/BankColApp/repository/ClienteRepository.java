package com.Bankcol.BankColApp.repository;

import com.Bankcol.BankColApp.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByCedula(Integer cedula);
    Optional<Cliente> findByCorreo(String correo);
    Optional<Cliente> findByUsuario(String usuario);
}
