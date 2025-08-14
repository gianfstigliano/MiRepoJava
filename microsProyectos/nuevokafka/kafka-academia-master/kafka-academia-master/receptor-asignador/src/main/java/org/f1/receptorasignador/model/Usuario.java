package org.f1.receptorasignador.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="usuarios")
public class Usuario {

    @Id
    private String id;
    private String nombreUsuario;

    @DBRef
    private List<Entrada> entradas = new ArrayList<>();

}
