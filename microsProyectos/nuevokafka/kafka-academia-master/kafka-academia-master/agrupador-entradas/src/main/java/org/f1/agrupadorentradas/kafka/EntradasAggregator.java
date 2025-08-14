package org.f1.agrupadorentradas.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Named;
import org.f1.agrupadorentradas.avro.EntradasKey;
import org.f1.agrupadorentradas.avro.EntradasValue;
import org.f1.asignadorpais.avro.EntradaPKey;
import org.f1.asignadorpais.avro.EntradaPValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
public class EntradasAggregator {

    @Autowired
    Aggregator aggregator;

    @Autowired
    Initializer initializer;

    @Bean
    public Function<KStream<EntradaPKey, EntradaPValue>, KStream<EntradasKey, EntradasValue>> aggregateEntradas() {
        return entradasStream -> entradasStream
                .peek((k, v) -> log.info("[aggregateEntradas] Recibida entrada -> clave: {}, valor: {}", k, v))
                .selectKey((k, v) -> EntradasKey.newBuilder().setIdUsuario(k.getIdUsuario()).build())
                .groupByKey()
                .aggregate(initializer, aggregator, Named.as("Entradas"), Materialized.as("Entradas"))
                .toStream()
                .peek((k, v) -> log.info("[aggregateEntradas] Entradas agrupadas -> clase: {}, valor: {}", k, v));
    }
}
