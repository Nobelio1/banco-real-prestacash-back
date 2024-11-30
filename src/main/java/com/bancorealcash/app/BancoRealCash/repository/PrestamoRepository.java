package com.bancorealcash.app.BancoRealCash.repository;

import com.bancorealcash.app.BancoRealCash.entities.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

}
