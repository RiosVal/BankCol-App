package com.BankCol.BankColApp.repository;

import com.BankCol.BankColApp.domain.Cdt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CdtRepository extends JpaRepository<Cdt, Integer> {
    Cdt findByNumero(Integer numeroCdt);

    Optional<Cdt> findCdtByNumero(Integer numero);
}
