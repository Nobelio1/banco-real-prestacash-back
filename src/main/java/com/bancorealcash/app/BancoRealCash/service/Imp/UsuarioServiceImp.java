package com.bancorealcash.app.BancoRealCash.service.Imp;

import com.bancorealcash.app.BancoRealCash.dto.ResponseDTO;
import com.bancorealcash.app.BancoRealCash.dto.UsuarioResponseDTO;
import com.bancorealcash.app.BancoRealCash.entities.Usuario;
import com.bancorealcash.app.BancoRealCash.entities.UsuarioInformacion;
import com.bancorealcash.app.BancoRealCash.repository.UsuarioInformacionRepository;
import com.bancorealcash.app.BancoRealCash.repository.UsuarioRepository;
import com.bancorealcash.app.BancoRealCash.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioInformacionRepository usuarioInformacionRepository;

    @Override
    public ResponseDTO<UsuarioResponseDTO> informacionUsuario(Integer id) {
        try {
            Usuario usuario = usuarioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            UsuarioInformacion usuarioInformacion = usuarioInformacionRepository.findByUsuarioId(id)
                    .orElseThrow(() -> new RuntimeException("Información del usuario no encontrada"));

            UsuarioResponseDTO usuarioResponseDTO = UsuarioResponseDTO.builder()
                    .usuarioId(usuario.getUsuarioId())
                    .correo(usuario.getCorreo())
                    .nombres(usuarioInformacion.getNombres())
                    .apellidos(usuarioInformacion.getApellidos())
                    .celular(usuarioInformacion.getCelular())
                    .dni(usuarioInformacion.getDni())
                    .direccion(usuarioInformacion.getDireccion())
                    .rol(usuario.getRol().getNombre())
                    .build();

            return ResponseDTO.<UsuarioResponseDTO>builder()
                    .code("000")
                    .data(usuarioResponseDTO)
                    .build();

        } catch (Exception e) {
            return ResponseDTO.<UsuarioResponseDTO>builder()
                    .code("999")
                    .data(null)
                    .build();
        }
    }

    @Transactional
    public void guardarUsuarioInformacion(UsuarioResponseDTO usuarioResponseDTO) {
        Usuario usuario = usuarioRepository.findById(usuarioResponseDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        UsuarioInformacion usuarioInformacion = new UsuarioInformacion();
        usuarioInformacion.setUsuario(usuario);
        usuarioInformacion.setNombres(usuarioResponseDTO.getNombres());
        usuarioInformacion.setApellidos(usuarioResponseDTO.getApellidos());
        usuarioInformacion.setCelular(usuarioResponseDTO.getCelular());
        usuarioInformacion.setDni(usuarioResponseDTO.getDni());
        usuarioInformacion.setDireccion(usuarioResponseDTO.getDireccion());

        usuarioInformacionRepository.save(usuarioInformacion);
    }
}
