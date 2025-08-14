package org.f1.receptorasignador.kafka;

import org.f1.asignadorusuariosentradas.avro.UsuariosEntradasKey;
import org.f1.asignadorusuariosentradas.avro.UsuariosEntradasValue;
import org.f1.receptorasignador.dto.EntradasDTO;
import org.f1.receptorasignador.dto.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper implements Mapper<UsuariosEntradasKey, UsuariosEntradasValue, UsuarioDTO> {


    @Override
    public UsuarioDTO toDTO(UsuariosEntradasKey key, UsuariosEntradasValue value) {

        return null;

    }
}

