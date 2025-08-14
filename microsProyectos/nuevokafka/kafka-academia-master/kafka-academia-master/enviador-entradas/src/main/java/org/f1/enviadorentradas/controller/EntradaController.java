package org.f1.enviadorentradas.controller;

import lombok.extern.slf4j.Slf4j;
import org.f1.enviadorentradas.dto.EntradaCrearDTO;
import org.f1.enviadorentradas.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping(value = "/entrada")
public class EntradaController {

    @Autowired
    EntradaService entradaService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void crearEntrada(@Valid @RequestBody EntradaCrearDTO entradaCrearDTO) {
        log.debug("Recibida peticion de crear una entrada");
        entradaService.crear(entradaCrearDTO);
    }

}