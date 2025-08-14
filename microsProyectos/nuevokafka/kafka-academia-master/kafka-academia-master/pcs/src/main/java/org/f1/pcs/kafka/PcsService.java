package org.f1.pcs.kafka;

import lombok.extern.slf4j.Slf4j;
import org.f1.enviadorentradas.avro.EntradaKey;
import org.f1.enviadorentradas.avro.EntradaValue;
import org.f1.enviadorentradas.avro.Evento;
import org.f1.pcs.avro.RecaudacionValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class PcsService {

    @Value("${environment.recaudacion-topic}")
    private String recaudacionTopic;

    @Autowired
    private KafkaTemplate<EntradaKey, RecaudacionValue> kafkaTemplate;

    private final Map<Evento, Double> recaudacionPorEvento = new HashMap<>();
    private final Map<Evento, Map<String, Double>> entradasPorUsuario = new HashMap<>(); // Usuario y precio de su entrada

    public void procesarEntrada(Evento evento, EntradaValue value) {
        String idUsuario = value.getIdUsuario();
        Double nuevoPrecio = value.getPrecio();

        // Inicializar mapas si no existen
        entradasPorUsuario.putIfAbsent(evento, new HashMap<>());
        recaudacionPorEvento.putIfAbsent(evento, 0.0);

        // Verificar si el usuario ya compró una entrada antes
        if (entradasPorUsuario.get(evento).containsKey(idUsuario)) {
            Double precioAnterior = entradasPorUsuario.get(evento).get(idUsuario);
            // Restar la entrada anterior del total antes de agregar la nueva
            recaudacionPorEvento.put(evento, recaudacionPorEvento.get(evento) - precioAnterior);
            log.info("Restando precio anterior: {} para usuario: {} en evento: {}", precioAnterior, idUsuario, evento);
        }

        // Guardar el nuevo precio de la entrada
        entradasPorUsuario.get(evento).put(idUsuario, nuevoPrecio);

        // Sumar el nuevo precio al total acumulado
        recaudacionPorEvento.put(evento, recaudacionPorEvento.get(evento) + nuevoPrecio);

        // Construir el objeto RecaudacionValue
        RecaudacionValue recaudacion = RecaudacionValue.newBuilder()
                .setIdUsuario(idUsuario)
                .setEvento(evento)
                .setRecaudacionTotal(recaudacionPorEvento.get(evento))
                .build();

        // Construir la clave de Kafka
        EntradaKey entradaKey = EntradaKey.newBuilder()
                .setIdUsuario(idUsuario)
                .build();

        // Enviar el mensaje a Kafka
        kafkaTemplate.send(recaudacionTopic, entradaKey, recaudacion);

        log.info("Enviado recaudación. Evento: {}, Usuario: {}, Nueva recaudación total: {}", evento, idUsuario, recaudacionPorEvento.get(evento));
    }
}


