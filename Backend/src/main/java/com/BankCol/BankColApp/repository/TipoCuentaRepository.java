package com.BankCol.BankColApp.repository;

import com.BankCol.BankColApp.domain.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Integer> {
    TipoCuenta findByDescripcion(String descripcion);

    Optional<TipoCuenta> findTipoCuentaByDescripcion(String descripcion);
}
