package org.f1.receptorasignador.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.f1.asignadorpais.avro.Evento;
import org.f1.receptorasignador.dto.EntradaDTO;
import org.f1.receptorasignador.dto.EntradasDTO;
import org.f1.receptorasignador.mapper.EntradaMapper;
import org.f1.receptorasignador.model.Entrada;
import org.f1.receptorasignador.repository.EntradaRepository;
import org.f1.receptorasignador.service.EntradaService;
import org.f1.receptorasignador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

@Slf4j
public class EntradaServiceImpl implements EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EntradaMapper entradaMapper;

    @Override
    public void crearEntradas(List<Entrada> entradas, String idUsuario) {
        for (Entrada nuevaEntrada : entradas) {
            // Buscar si el usuario ya tiene una entrada para ese evento
            Entrada entradaExistente = entradaRepository.findByIdUsuarioAndEvento(idUsuario, nuevaEntrada.getEvento());

            if (entradaExistente != null) {
                // Si existe, eliminarla
                entradaRepository.delete(entradaExistente);
            }

            // Asociar la nueva entrada al usuario
            nuevaEntrada.setIdUsuario(idUsuario);
        }

        // Guardar las nuevas entradas
        entradaRepository.saveAll(entradas);

        // Actualizar la relación en UsuarioService
        usuarioService.vincularEntradaAUsuario(idUsuario, entradas);
    }

    @Override
    public List<EntradaDTO> obtenerTodasLasEntradas() {
        List<Entrada> entradas = entradaRepository.findAll();
        return entradaMapper.listToDto(entradas);
    }

    @Override
    public List<Entrada> obtenerEntradasPorEvento(Evento evento) {
        return entradaRepository.findByEvento(evento);
    }
}
