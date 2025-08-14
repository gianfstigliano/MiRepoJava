package org.f1.receptorasignador.controller;


import org.f1.asignadorpais.avro.Evento;
import org.f1.receptorasignador.dto.EntradaDTO;
import org.f1.receptorasignador.dto.EntradasDTO;
import org.f1.receptorasignador.model.Entrada;
import org.f1.receptorasignador.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;


    @GetMapping
    public ResponseEntity<List<EntradaDTO>> obtenerEntradas() {
        List<EntradaDTO> entradas = entradaService.obtenerTodasLasEntradas();
        return new ResponseEntity<>(entradas, HttpStatus.OK);
    }


    @GetMapping("/{evento}")
    public ResponseEntity<List<Entrada>> getEntradasByEvento(@PathVariable Evento evento) {
        List<Entrada> entradas = entradaService.obtenerEntradasPorEvento(evento);
        return new ResponseEntity<>(entradas, HttpStatus.OK);
    }
}
