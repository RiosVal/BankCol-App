package com.Tecnicas.BancoApp.repository;

import com.Tecnicas.BancoApp.domain.Consignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsignacionRepository extends JpaRepository<Consignacion, Integer> {
}
