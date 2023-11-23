package com.BankCol.BankColApp.repository;

import com.BankCol.BankColApp.domain.Destinatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinatarioRepository extends JpaRepository<Destinatario, Integer> {
    Destinatario findByCedulaDestinatario(Integer cedula);
    Optional<Destinatario> findDestinatarioByNumcuentaDestinatario(Integer numeroCuenta);
}
