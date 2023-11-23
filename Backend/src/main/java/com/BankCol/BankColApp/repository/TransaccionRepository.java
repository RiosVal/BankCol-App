package com.BankCol.BankColApp.repository;

import com.BankCol.BankColApp.domain.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {
    Transaccion findByCodigoTransaccion(String codigo);
    Optional<Transaccion> findTransaccionByCodigoTransaccion(String codigo);
}
