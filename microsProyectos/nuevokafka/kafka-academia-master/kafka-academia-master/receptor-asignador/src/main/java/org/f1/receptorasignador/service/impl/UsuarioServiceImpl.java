package org.f1.receptorasignador.service.impl;

import org.f1.receptorasignador.dto.EntradasDTO;
import org.f1.receptorasignador.dto.UsuarioDTO;
import org.f1.receptorasignador.mapper.UsuarioMapper;
import org.f1.receptorasignador.model.Entrada;
import org.f1.receptorasignador.model.Usuario;
import org.f1.receptorasignador.repository.UsuarioRepository;
import org.f1.receptorasignador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public Usuario crearUsuario(String idUsuario, String nombreUsuario) {
        return usuarioRepository.findById(idUsuario).orElseGet(() -> {
            Usuario usuario = new Usuario();
            usuario.setId(idUsuario);
            usuario.setNombreUsuario(nombreUsuario);

            return usuarioRepository.save(usuario);
        });
    }

    @Override
    public void vincularEntradaAUsuario(String id, List<Entrada> entradas) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new NoSuchElementException("no existe usuario con ese id"));

        usuarioExistente.getEntradas().addAll(entradas);
        usuarioRepository.save(usuarioExistente);
    }

    @Override
    public List<UsuarioDTO> obtenerTodosLosUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarioMapper.listToDto(usuarios);
    }


}
