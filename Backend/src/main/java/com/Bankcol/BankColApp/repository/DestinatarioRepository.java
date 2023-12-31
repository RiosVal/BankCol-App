package com.Bankcol.BankColApp.repository;

import com.Bankcol.BankColApp.domain.Destinatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinatarioRepository extends JpaRepository<Destinatario, Integer> {
}