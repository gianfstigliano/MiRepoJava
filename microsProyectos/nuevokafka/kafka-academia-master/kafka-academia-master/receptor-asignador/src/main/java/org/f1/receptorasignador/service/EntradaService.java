package org.f1.receptorasignador.service;

import org.f1.asignadorpais.avro.Evento;
import org.f1.receptorasignador.dto.EntradaDTO;
import org.f1.receptorasignador.dto.EntradasDTO;
import org.f1.receptorasignador.model.Entrada;
import org.f1.receptorasignador.model.Usuario;

import java.util.List;

public interface EntradaService {
    List<EntradaDTO> obtenerTodasLasEntradas();

    List<Entrada> obtenerEntradasPorEvento(Evento evento);

    void crearEntradas(List<Entrada> entradas, String idUsuario);
}
