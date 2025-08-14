package org.f1.receptorasignador.mapper;

import org.f1.receptorasignador.dto.EntradasDTO;
import org.f1.receptorasignador.model.Entrada;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface EntradasMapper {
    EntradasDTO toDTO(Entrada entrada);
    Entrada toEntity(EntradasDTO dto);

    List<EntradasDTO> listToDto(List<Entrada> entradas);
}
