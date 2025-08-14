package org.f1.receptorasignador.controller;

import org.f1.receptorasignador.dto.UsuarioDTO;
import org.f1.receptorasignador.model.Usuario;
import org.f1.receptorasignador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    ResponseEntity<List<UsuarioDTO>> obtenerTodosLosUsuarios(){
        List<UsuarioDTO> usuarios = usuarioService.obtenerTodosLosUsuarios();
        return new ResponseEntity<>(usuarios,HttpStatus.OK);
    }
}
