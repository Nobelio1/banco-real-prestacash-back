package com.bancorealcash.app.BancoRealCash.service.Imp;

import com.bancorealcash.app.BancoRealCash.dto.SesionResponseDTO;
import com.bancorealcash.app.BancoRealCash.dto.UsuarioDTO;
import com.bancorealcash.app.BancoRealCash.entities.Rol;
import com.bancorealcash.app.BancoRealCash.entities.Usuario;
import com.bancorealcash.app.BancoRealCash.exception.BadRequestException;
import com.bancorealcash.app.BancoRealCash.repository.RolRepository;
import com.bancorealcash.app.BancoRealCash.repository.UsuarioRepository;
import com.bancorealcash.app.BancoRealCash.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SesionServiceImp implements SesionService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;


    @Override
    public SesionResponseDTO registrar(UsuarioDTO usuario) {
        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            throw new BadRequestException("El correo ya está registrado.");
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCorreo(usuario.getCorreo());
        nuevoUsuario.setContrasena(usuario.getContrasena());

        Rol rolCliente = rolRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado."));
        nuevoUsuario.setRol(rolCliente);

        usuarioRepository.save(nuevoUsuario);

        return SesionResponseDTO.builder()
                .usuarioId(nuevoUsuario.getUsuarioId())
                .rolId(nuevoUsuario.getRol().getRolId())
                .rolNombre(nuevoUsuario.getRol().getNombre())
                .build();
    }

    public SesionResponseDTO validarUsuario(String correo, String contrasena) {
        Usuario usuarioOpt = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return SesionResponseDTO.builder()
                .usuarioId(usuarioOpt.getUsuarioId())
                .rolId(usuarioOpt.getRol().getRolId())
                .rolNombre(usuarioOpt.getRol().getNombre())
                .build();
    }
}
