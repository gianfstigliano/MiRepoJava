package org.f1.pcs.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.f1.enviadorentradas.avro.EntradaKey;
import org.f1.enviadorentradas.avro.EntradaValue;
import org.f1.enviadorentradas.avro.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
public class PcsListener {

    @Autowired
    private PcsService pcsService;

    @KafkaListener(topics = "entradas")
    public void process(ConsumerRecord<EntradaKey, EntradaValue> entrada) {
        log.info("Procesando entrada. Datos internos: topic -> {}, partition -> {}, offset -> {}, key: {}, value: {}",
                entrada.topic(), entrada.partition(), entrada.offset(), entrada.key(), entrada.value());

        // Asumir que entrada.value().getEvento() es un Enum
        Evento evento = Evento.valueOf(entrada.value().getEvento().name());
        pcsService.procesarEntrada(evento, entrada.value());
    }
}

