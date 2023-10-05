package com.Tecnicas.BancoApp.repository;

import com.Tecnicas.BancoApp.domain.Destinatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinatarioRepository extends JpaRepository<Destinatario, Integer> {
}
