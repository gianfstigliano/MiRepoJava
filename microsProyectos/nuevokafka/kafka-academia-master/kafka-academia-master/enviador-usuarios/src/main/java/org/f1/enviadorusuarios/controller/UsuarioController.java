package org.f1.enviadorusuarios.controller;

import lombok.extern.slf4j.Slf4j;
import org.f1.enviadorusuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public ResponseEntity<String> crearUsuario(@RequestParam String nombre, @RequestParam String mail) {
        log.debug("Recibida petición para crear un usuario con el correo: {}", mail);
        String usuarioId = usuarioService.crear(nombre, mail);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado exitosamente: " + usuarioId);
    }


}