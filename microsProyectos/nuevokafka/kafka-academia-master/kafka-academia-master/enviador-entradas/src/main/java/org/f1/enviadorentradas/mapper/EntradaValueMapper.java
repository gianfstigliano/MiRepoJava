package org.f1.enviadorentradas.mapper;


import org.f1.enviadorentradas.avro.EntradaValue;
import org.f1.enviadorentradas.avro.Evento;
import org.f1.enviadorentradas.avro.TipoEntrada;
import org.f1.enviadorentradas.dto.EntradaDTO;


public class EntradaValueMapper implements Mapper<EntradaValue, EntradaDTO> {

    @Override
    public EntradaValue dtoToEntity(EntradaDTO dto) {

        return EntradaValue.newBuilder()
                .setIdUsuario(dto.getIdUsuario().toString())
                .setTipoEntrada(TipoEntrada.valueOf(dto.getTipoEntrada().name())) // Convierte el enum DTO al enum Avro
                .setEvento(Evento.valueOf(dto.getEvento().name()))
                .setPrecio(dto.getPrecio())
                .build();
    }
}
