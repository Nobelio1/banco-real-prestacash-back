package com.bancorealcash.app.BancoRealCash.service;

import com.bancorealcash.app.BancoRealCash.dto.PrestamoDTO;

import java.util.List;

public interface PrestamoService {
    public List<PrestamoDTO> obtenerTodosLosPrestamos();
    public boolean actualizarMora(Integer prestamoId, Integer mora);
    public boolean actualizarEstado(Integer prestamoId, String estado);
}
