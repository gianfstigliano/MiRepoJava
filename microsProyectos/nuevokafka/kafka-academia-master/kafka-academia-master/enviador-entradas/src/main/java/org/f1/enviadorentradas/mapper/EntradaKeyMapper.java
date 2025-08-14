package org.f1.enviadorentradas.mapper;


import org.f1.enviadorentradas.avro.EntradaKey;
import org.f1.enviadorentradas.dto.EntradaDTO;


public class EntradaKeyMapper implements Mapper<EntradaKey, EntradaDTO> {

    @Override
    public EntradaKey dtoToEntity(EntradaDTO dto) {

        return EntradaKey
                .newBuilder()
                .setIdUsuario(dto.getIdUsuario().toString())
                .build();
    }
}
