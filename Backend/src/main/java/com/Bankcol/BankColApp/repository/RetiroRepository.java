package com.Tecnicas.BancoApp.repository;

import com.Tecnicas.BancoApp.domain.Retiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetiroRepository extends JpaRepository<Retiro, Integer> {
}
