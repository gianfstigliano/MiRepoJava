package org.f1.receptorasignador.mapper;


import org.f1.receptorasignador.dto.EntradaDTO;
import org.f1.receptorasignador.dto.EntradasDTO;
import org.f1.receptorasignador.model.Entrada;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntradaMapper {

    EntradaDTO toDTO(Entrada entrada);
    Entrada toEntity(EntradasDTO dto);

    List<EntradaDTO> listToDto(List<Entrada> entradas);



}
