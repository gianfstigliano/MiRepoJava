package org.f1.receptorasignador.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.f1.asignadorpais.avro.Evento;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="entradas")
public class Entrada {

    @Id
    private String idEntrada;
    private String tipoEntrada;
    private Evento evento;
    private Double precio;
    private String pais;

    private String idUsuario;  // Relación con Usuario
}
