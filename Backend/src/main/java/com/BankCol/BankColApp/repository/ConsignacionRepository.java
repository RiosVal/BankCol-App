package com.BankCol.BankColApp.repository;

import com.BankCol.BankColApp.domain.Consignacion;
import com.BankCol.BankColApp.dto.ConsignacionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsignacionRepository extends JpaRepository<Consignacion, Integer> {
    Consignacion findByCodigoConsignacion(String codigo);
    Optional<Consignacion> findConsignacionByCodigoConsignacion(String codigo);

}
