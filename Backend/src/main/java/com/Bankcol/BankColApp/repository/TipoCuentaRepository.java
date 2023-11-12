package com.Bankcol.BankColApp.repository;

import com.Bankcol.BankColApp.domain.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Integer> {



}
