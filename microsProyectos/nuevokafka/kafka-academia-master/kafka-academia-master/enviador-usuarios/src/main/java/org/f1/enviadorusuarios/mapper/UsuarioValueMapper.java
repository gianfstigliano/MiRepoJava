package org.f1.enviadorusuarios.mapper;


import org.f1.enviadorusuarios.avro.UsuarioValue;
import org.f1.enviadorusuarios.dto.UsuarioDTO;

public class UsuarioValueMapper implements Mapper<UsuarioValue, UsuarioDTO> {

    @Override
    public UsuarioValue dtoToEntity(UsuarioDTO dto) {

        return UsuarioValue.newBuilder()
                .setId(dto.getId().toString())
                .setNombre(dto.getNombre())
                .setMail(dto.getMail())
                .build();
    }
}
