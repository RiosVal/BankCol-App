package com.BankCol.BankColApp.repository;

import com.BankCol.BankColApp.domain.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    Cuenta findByNumeroCuenta(Integer numeroCuenta);

    Optional<Cuenta> findCuentaByNumeroCuenta(Integer numeroCuenta);
}