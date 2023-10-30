package com.Bankcol.BankColApp.repository;

import com.Bankcol.BankColApp.domain.Consignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsignacionRepository extends JpaRepository<Consignacion, Integer> {
}