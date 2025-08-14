package org.f1.agrupadorentradas;


import org.apache.kafka.streams.kstream.Aggregator;
import org.f1.agrupadorentradas.avro.EntradasKey;
import org.f1.agrupadorentradas.avro.EntradasValue;
import org.f1.asignadorpais.avro.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AggregatorTest {
    /*
    private Aggregator<EntradasKey, EntradaPValue, EntradasValue> aggregator;

    @BeforeEach
    public void setUp() {
        aggregator = new Aggregator();
    }

    @Test
    public void testApply_AgregaNuevaEntrada() {
        // Clave de agrupación
        EntradasKey entradasAgrupadasKey = EntradasKey.newBuilder()
                .setIdUsuario(UUID.randomUUID().toString())
                .build();

        // Valor de entrada a agregar
        EntradaPValue entradaNueva = EntradaPValue.newBuilder()
                .setTipoEntrada(TipoEntrada.VIP)
                .setEvento(Evento.MONZA)
                .setPrecio(300.0)
                .setPais("Italia")
                .build();

        // Lista inicial de entradas (vacía)
        EntradasValue entradasIniciales = EntradasValue.newBuilder()
                .setEntradas(new ArrayList<>()) // Comienza sin entradas
                .build();

        // Ejecutamos el método apply()
        EntradasValue resultado = aggregator.apply(entradasAgrupadasKey, entradaNueva, entradasIniciales);

        // Validamos que la nueva entrada fue agregada
        assertNotNull(resultado);
        assertEquals(1, resultado.getEntradas().size());
        assertEquals(Evento.MONZA, resultado.getEntradas().get(0).getEvento());
        assertEquals("Italia", resultado.getEntradas().get(0).getPais());
    }

    @ParameterizedTest
    @CsvSource({
            "MONZA, Italia",
            "MONACO, Francia",
            "SILVERSTONE, Reino Unido",
            "SPA, Bélgica"
    })
    public void testApply_EliminaEventoExistente(String evento, String paisEsperado) {
        // Clave de agrupación
        EntradasKey entradasAgrupadasKey = EntradasKey.newBuilder()
                .setIdUsuario(UUID.randomUUID().toString())
                .build();

        // Entrada existente que debería ser eliminada
        Entrada entradaExistente = Entrada.newBuilder()
                .setTipoEntrada(TipoEntrada.VIP)
                .setEvento(Evento.valueOf(evento))
                .setPrecio(300.0)
                .setPais(paisEsperado)
                .build();

        List<Entrada> listaEntradas = new ArrayList<>();
        listaEntradas.add(entradaExistente);

        // Estado inicial con una entrada existente
        EntradasValue entradasIniciales = EntradasValue.newBuilder()
                .setEntradas(listaEntradas)
                .build();

        // Nueva entrada con el mismo evento (debe reemplazar la anterior)
        EntradaPValue nuevaEntrada = EntradaPValue.newBuilder()
                .setTipoEntrada(TipoEntrada.VIP)
                .setEvento(Evento.valueOf(evento))
                .setPrecio(400.0)
                .setPais(paisEsperado)
                .build();

        // Ejecutamos el método apply()
        EntradasValue resultado = aggregator.apply(entradasAgrupadasKey, nuevaEntrada, entradasIniciales);

        // Validamos que la entrada anterior se eliminó y se agregó la nueva
        assertEquals(1, resultado.getEntradas().size());
        assertEquals(Evento.valueOf(evento), resultado.getEntradas().get(0).getEvento());
        assertEquals(400.0, resultado.getEntradas().get(0).getPrecio());
    }

     */
}

