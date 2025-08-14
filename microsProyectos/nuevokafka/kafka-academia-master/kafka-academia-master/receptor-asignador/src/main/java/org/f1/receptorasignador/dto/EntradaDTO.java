package org.f1.receptorasignador.dto;

import lombok.Data;
import org.f1.asignadorpais.avro.Evento;
@Data
public class EntradaDTO {
    private String idEntrada;
    private String tipoEntrada;
    private Evento evento;
    private Double precio;
    private String pais;

    private String idUsuario;
}
