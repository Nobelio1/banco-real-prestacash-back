package com.bancorealcash.app.BancoRealCash.service.Imp;

import com.bancorealcash.app.BancoRealCash.dto.UsuarioDTO;
import com.bancorealcash.app.BancoRealCash.entities.Rol;
import com.bancorealcash.app.BancoRealCash.entities.Usuario;
import com.bancorealcash.app.BancoRealCash.exception.BadRequestException;
import com.bancorealcash.app.BancoRealCash.repository.UsuarioRepository;
import com.bancorealcash.app.BancoRealCash.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SesionServiceImp implements SesionService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void registrar(UsuarioDTO usuario) {

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCorreo(usuario.getCorreo());
        nuevoUsuario.setContrasena(usuario.getContrasena());

        Rol rolCliente = new Rol();
        rolCliente.setRolId(1);
        nuevoUsuario.setRol(rolCliente);

        try {
            usuarioRepository.save(nuevoUsuario);
        } catch (DataIntegrityViolationException e) {
            throw new BadRequestException("El correo ya está registrado.");
        } catch (Exception e) {
            throw new BadRequestException("Error al registrar el usuario.");
        }
    }
}
