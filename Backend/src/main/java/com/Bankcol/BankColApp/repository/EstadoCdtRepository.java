package com.Bankcol.BankColApp.repository;

import com.Bankcol.BankColApp.domain.EstadoCdt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCdtRepository extends JpaRepository<EstadoCdt, Integer> {
}