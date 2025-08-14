package org.f1.receptorasignador.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.f1.asignadorpais.avro.Evento;
import org.f1.asignadorusuariosentradas.avro.UsuariosEntradasValue;
import org.f1.receptorasignador.model.Entrada;
import org.f1.receptorasignador.model.Usuario;
import org.f1.receptorasignador.service.EntradaService;
import org.f1.receptorasignador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;


import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Configuration

public class Listener {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EntradaService entradaService;

    @KafkaListener(topics = "asignaciones-entradas-usuarios")
    public void consume(ConsumerRecord<String, UsuariosEntradasValue> record) {
        log.info("Procesando mensaje de Kafka: {}", record.value());

        String idUsuario = record.value().getIdUsuario();
        String nombreUsuario = record.value().getNombreUsuario();
        List<Entrada> entradas = mapearAvroAEntrada(record.value().getEntradas());

        // Crear el usuario si no existe
        Usuario usuario = usuarioService.crearUsuario(idUsuario, nombreUsuario);



        // Crear entradas y asociarlas con el usuario
        entradaService.crearEntradas(entradas, usuario.getId());
    }

    // Método auxiliar para convertir el AVRO en entidades de Entrada
    private List<Entrada> mapearAvroAEntrada(List<org.f1.asignadorpais.avro.Entrada> avroEntradas) {
        return avroEntradas.stream()
                .map(avroEntrada -> new Entrada(
                        null,  // El ID será generado automáticamente
                        avroEntrada.getTipoEntrada().toString(),
                        Evento.valueOf(avroEntrada.getEvento().toString()),
                        avroEntrada.getPrecio(),
                        avroEntrada.getPais(),
                        null  // Usuario se asigna más tarde
                ))
                .collect(Collectors.toList());
    }
}