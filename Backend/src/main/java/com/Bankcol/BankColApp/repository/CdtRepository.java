package com.Tecnicas.BancoApp.repository;

import com.Tecnicas.BancoApp.domain.Cdt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdtRepository extends JpaRepository<Cdt, Integer> {
}
