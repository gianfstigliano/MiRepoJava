package org.f1.agrupadorentradas.kafka;


import org.f1.agrupadorentradas.avro.EntradasKey;
import org.f1.agrupadorentradas.avro.EntradasValue;
import org.f1.asignadorpais.avro.Entrada;
import org.f1.asignadorpais.avro.EntradaPValue;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Aggregator implements org.apache.kafka.streams.kstream.Aggregator<EntradasKey, EntradaPValue, EntradasValue> {

    @Override
    public EntradasValue apply(EntradasKey entradasAgrupadasKey,
                               EntradaPValue entradaValue,
                               EntradasValue entradasAgrupadasValue) {

        entradasAgrupadasValue = EntradasValue.newBuilder()
                .setEntradas(entradasAgrupadasValue.getEntradas()
                        .stream()
                        .filter(c -> !entradaValue.getEvento().equals(c.getEvento()))
                        .collect(Collectors.toList())).build();

       entradasAgrupadasValue.getEntradas().add(createEntrada(entradaValue));

        return entradasAgrupadasValue;
    }

    private Entrada createEntrada(EntradaPValue entradaValue){
        return Entrada.newBuilder()
                .setTipoEntrada(entradaValue.getTipoEntrada())
                .setEvento(entradaValue.getEvento())
                .setPrecio(entradaValue.getPrecio())
                .setPais(entradaValue.getPais())
                .build();
    }
}
