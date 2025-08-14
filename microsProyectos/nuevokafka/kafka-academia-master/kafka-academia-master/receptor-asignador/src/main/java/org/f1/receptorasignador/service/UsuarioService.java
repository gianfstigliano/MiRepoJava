package org.f1.receptorasignador.service;

import org.f1.receptorasignador.dto.EntradasDTO;
import org.f1.receptorasignador.dto.UsuarioDTO;
import org.f1.receptorasignador.model.Entrada;
import org.f1.receptorasignador.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> obtenerTodosLosUsuarios();

    Usuario crearUsuario(String idUsuario, String nombreUsuario);
    void vincularEntradaAUsuario(String idUsuario, List<Entrada> entradas);
}
