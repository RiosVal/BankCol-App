package com.BankCol.BankColApp.repository;

import com.BankCol.BankColApp.domain.EstadoCdt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoCdtRepository extends JpaRepository<EstadoCdt, Integer> {
    EstadoCdt findByDescripcion(String descripcion);

    Optional<EstadoCdt> findEstadoCdtByDescripcion(String descripcion);
}
