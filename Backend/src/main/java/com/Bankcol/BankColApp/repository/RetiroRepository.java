package com.Bankcol.BankColApp.repository;

import com.Bankcol.BankColApp.domain.Cuenta;
import com.Bankcol.BankColApp.domain.Retiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.Optional;

@Repository
public interface RetiroRepository extends JpaRepository<Retiro, Integer> {
}
