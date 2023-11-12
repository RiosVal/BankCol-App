package com.Bankcol.BankColApp.repository;

import com.Bankcol.BankColApp.domain.Cdt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdtRepository extends JpaRepository<Cdt, Integer> {



}
