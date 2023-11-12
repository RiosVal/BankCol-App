package com.Bankcol.BankColApp.repository;

import com.Bankcol.BankColApp.domain.Cliente;
import com.Bankcol.BankColApp.domain.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    Optional <Cuenta> findByNoCuenta(Integer noCuenta);
}

