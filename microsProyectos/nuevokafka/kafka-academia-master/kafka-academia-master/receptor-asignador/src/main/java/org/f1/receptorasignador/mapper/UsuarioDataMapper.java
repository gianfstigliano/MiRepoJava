package org.f1.receptorasignador.mapper;

import org.f1.receptorasignador.dto.UsuarioDataDTO;
import org.f1.receptorasignador.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioDataMapper {
    UsuarioDataDTO toDto(Usuario usuario);
}
