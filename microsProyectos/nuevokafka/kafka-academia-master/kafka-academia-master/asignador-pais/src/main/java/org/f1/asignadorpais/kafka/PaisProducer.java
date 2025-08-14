package org.f1.asignadorpais.kafka;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.f1.asignadorpais.avro.EntradaPKey;
import org.f1.asignadorpais.avro.EntradaPValue;
import org.f1.asignadorpais.avro.Evento;
import org.f1.asignadorpais.avro.TipoEntrada;
import org.f1.enviadorentradas.avro.EntradaKey;
import org.f1.enviadorentradas.avro.EntradaValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
@Slf4j
@Data
public class PaisProducer {
    @Autowired
    private KafkaTemplate<EntradaPKey, EntradaPValue> kafkaTemplate;

    public void send(EntradaKey entradaKey, EntradaValue entradaValue) {
        EntradaPKey key = EntradaPKey.newBuilder().setIdUsuario(entradaKey.getIdUsuario()).build();
        EntradaPValue value = EntradaPValue.newBuilder()
                .setIdUsuario(entradaValue.getIdUsuario())
                .setTipoEntrada(TipoEntrada.valueOf(entradaValue.getTipoEntrada().name()))
                .setEvento(Evento.valueOf(entradaValue.getEvento().name()))
                .setPrecio(entradaValue.getPrecio())
                .setPais(obtenerPaisPorEvento(entradaValue.getEvento().name()))

                .build();
        log.info("Enviando mensaje");
        kafkaTemplate.send("asignacion-pais", key, value);
        log.info("Mensaje enviado");
    }

    protected String obtenerPaisPorEvento(String evento) {
        switch (evento) {
            case "MONZA": return "Italia";
            case "MONACO": return "Francia";
            case "SILVERSTONE": return "Reino Unido";
            case "SPA": return "Bélgica";
            default: return "Desconocido";
        }
    }
}
