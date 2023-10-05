package com.Tecnicas.BancoApp.repository;

import com.Tecnicas.BancoApp.domain.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Integer> {
}
