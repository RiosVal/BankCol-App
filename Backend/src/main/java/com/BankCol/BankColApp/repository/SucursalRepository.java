package com.BankCol.BankColApp.repository;

import com.BankCol.BankColApp.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
    //No se puede hacer la validacion con optional porque no se como hacer con los strings con espacios

    Sucursal findByDireccion(String direccion);

}
