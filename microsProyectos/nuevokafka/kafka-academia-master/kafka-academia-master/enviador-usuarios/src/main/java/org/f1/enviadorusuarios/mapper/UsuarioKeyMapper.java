package org.f1.enviadorusuarios.mapper;


import org.f1.enviadorusuarios.avro.UsuarioKey;
import org.f1.enviadorusuarios.dto.UsuarioDTO;

public class UsuarioKeyMapper implements Mapper<UsuarioKey, UsuarioDTO> {

    @Override
    public UsuarioKey dtoToEntity(UsuarioDTO dto) {

        return UsuarioKey
                .newBuilder()
                .setId(dto.getId().toString())
                .build();
    }
}
