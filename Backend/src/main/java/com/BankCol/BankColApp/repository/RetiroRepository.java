package com.BankCol.BankColApp.repository;

import com.BankCol.BankColApp.domain.Retiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetiroRepository extends JpaRepository<Retiro, Integer> {
    Retiro findByCodigoRetiro(String codigo);

    Optional<Retiro> findRetiroByCodigoRetiro(String codigo);
}
