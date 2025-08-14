package org.f1.receptorasignador.mapper;

import org.f1.receptorasignador.dto.UsuarioDTO;
import org.f1.receptorasignador.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = EntradaMapper.class)
public interface UsuarioMapper {



    UsuarioDTO toDTO(Usuario usuario);

    List<UsuarioDTO> listToDto (List<Usuario> usuarios);
}
