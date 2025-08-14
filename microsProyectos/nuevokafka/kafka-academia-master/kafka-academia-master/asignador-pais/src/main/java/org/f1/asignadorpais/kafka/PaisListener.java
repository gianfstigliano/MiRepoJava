package org.f1.asignadorpais.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.f1.enviadorentradas.avro.EntradaKey;
import org.f1.enviadorentradas.avro.EntradaValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
public class PaisListener {

    @Autowired
    private PaisProducer paisProducer;

    @KafkaListener(topics = "entradas")
    public void process(ConsumerRecord<EntradaKey, EntradaValue> entradas) {
        log.info("Procesando entrada. Datos internos: topic -> {}, partition -> {}, offset -> {}, key: {}, value: {}",
                entradas.topic(), entradas.partition(), entradas.offset(), entradas.key(), entradas.value());

        // Obtener la entrada desde el mensaje
        EntradaKey entradak = entradas.key();
        EntradaValue entradav = entradas.value();

        log.info("Mensaje enriquecido enviado a topic '{}': {}", entradav);

        paisProducer.send(entradak,entradav);
    }
}

