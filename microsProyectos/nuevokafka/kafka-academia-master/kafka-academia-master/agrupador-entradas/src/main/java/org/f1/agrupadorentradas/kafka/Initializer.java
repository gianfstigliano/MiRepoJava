package org.f1.agrupadorentradas.kafka;

import org.f1.agrupadorentradas.avro.EntradasValue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Initializer implements org.apache.kafka.streams.kstream.Initializer<EntradasValue> {
    @Override
    public EntradasValue apply() {
        return EntradasValue.newBuilder()
                .setEntradas(new ArrayList<>())
                .build();
    }
}
