package com.bancorealcash.app.BancoRealCash.repository;

import com.bancorealcash.app.BancoRealCash.entities.Cuota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuotaRepository extends JpaRepository<Cuota, Integer> {
}
