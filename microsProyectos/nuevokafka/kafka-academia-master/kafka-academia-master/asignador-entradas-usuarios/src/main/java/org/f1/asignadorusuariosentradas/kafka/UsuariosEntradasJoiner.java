package org.f1.asignadorusuariosentradas.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Named;
import org.f1.agrupadorentradas.avro.EntradasKey;
import org.f1.agrupadorentradas.avro.EntradasValue;
import org.f1.asignadorpais.avro.Entrada;
import org.f1.asignadorusuariosentradas.avro.UsuariosEntradasKey;
import org.f1.asignadorusuariosentradas.avro.UsuariosEntradasValue;
import org.f1.enviadorusuarios.avro.UsuarioKey;
import org.f1.enviadorusuarios.avro.UsuarioValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.BiFunction;


@Configuration
@Slf4j
public class UsuariosEntradasJoiner {
    @Bean
    public BiFunction<KStream<UsuarioKey, UsuarioValue>, KStream<EntradasKey, EntradasValue>, KStream<UsuariosEntradasKey, UsuariosEntradasValue>> joiner() {
        return (usuarioStream, entradasStream) -> {
// Creamos KTables de usuarios y entradas
            KTable<UsuariosEntradasKey, UsuarioValue> usuariosKTable = usuarioStream
                    .selectKey((k, v) -> UsuariosEntradasKey.newBuilder().setIdUsuario(k.getId()).build())
                    .toTable(Named.as("UsuarioEntradas"), Materialized.as("UsuarioEntradas"));
            KTable<UsuariosEntradasKey, EntradasValue> entradasKTable = entradasStream
                    .selectKey((k, v) -> UsuariosEntradasKey.newBuilder().setIdUsuario(k.getIdUsuario()).build())
                    .toTable(Named.as("entradas-usuario"), Materialized.as("entradas-usuario"));
// Realizamos el join entre las KTables
            return usuariosKTable.join(entradasKTable, // Join de las tablas
                            (usuarioValue, entradasValue) -> {
// Si las entradas tienen más de una entrada por usuario
                                List<Entrada> entradas = entradasValue.getEntradas();
                                log.info("Entradas del usuario: {}", entradas);
// Creamos el objeto de salida, combinando el usuario con las entradas
                                return UsuariosEntradasValue.newBuilder()
                                        .setIdUsuario(usuarioValue.getId())
                                        .setNombreUsuario(usuarioValue.getNombre())
                                        .setEntradas(entradasValue.getEntradas()) // Usamos setEntradas en lugar de setEntradasList
                                        .build();
                            })
                    .toStream()
                    .peek((k, v) -> log.info("[joiner] Sending message with key: {} and value: {}", k, v));
        };
    }
}

