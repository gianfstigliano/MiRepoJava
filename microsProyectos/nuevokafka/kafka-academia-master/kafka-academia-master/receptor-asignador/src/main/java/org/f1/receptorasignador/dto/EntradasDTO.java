package org.f1.receptorasignador.dto;

import lombok.*;
import org.f1.asignadorpais.avro.Evento;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class EntradasDTO {
    private String idEntrada;
    private String tipoEntrada;
    private Evento evento;
}