package org.f1.enviadorentradas.dto;

import lombok.Data;
import org.f1.enviadorentradas.enums.Evento;
import org.f1.enviadorentradas.enums.TipoEntrada;

import java.util.UUID;

@Data
public class EntradaCrearDTO {
    private UUID idUsuario;
    private TipoEntrada tipoEntrada;
    private Evento evento;
}
