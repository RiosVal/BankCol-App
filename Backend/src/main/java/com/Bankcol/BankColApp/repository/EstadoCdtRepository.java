package com.Tecnicas.BancoApp.repository;

import com.Tecnicas.BancoApp.domain.EstadoCdt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCdtRepository extends JpaRepository<EstadoCdt, Integer> {
}
