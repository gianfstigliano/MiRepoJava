package org.f1.receptorasignador.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioDTO {
    private String id;
    private String nombreUsuario;
    private List<EntradasDTO> entradas;

}
