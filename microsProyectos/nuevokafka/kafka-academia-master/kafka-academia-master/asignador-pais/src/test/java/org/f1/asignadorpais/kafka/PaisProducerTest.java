package org.f1.asignadorpais.kafka;

import org.f1.asignadorpais.avro.EntradaPKey;

import org.f1.asignadorpais.avro.EntradaPValue;
import org.f1.enviadorentradas.avro.EntradaKey;
import org.f1.enviadorentradas.avro.EntradaValue;
import org.f1.enviadorentradas.avro.Evento;
import org.f1.enviadorentradas.avro.TipoEntrada;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PaisProducerTest {

    @InjectMocks
    private PaisProducer paisProducer;

    @Mock
    private KafkaTemplate<EntradaPKey, EntradaPValue> kafkaTemplate;

    @Test
    public void testSend() {

        // Datos de entrada
        EntradaKey entradaKey = new EntradaKey(UUID.randomUUID().toString());
        EntradaValue entradaValue = new EntradaValue(entradaKey.getIdUsuario(), TipoEntrada.VIP, Evento.MONZA, null,  300.0);

        // Llamamos al método send()
        paisProducer.send(entradaKey, entradaValue);

        // Construcción esperada del mensaje
        EntradaPKey expectedKey = EntradaPKey.newBuilder().setIdUsuario(entradaKey.getIdUsuario()).build();
        EntradaPValue expectedValue = EntradaPValue.newBuilder()
                .setIdUsuario(entradaValue.getIdUsuario())
                .setTipoEntrada(org.f1.asignadorpais.avro.TipoEntrada.valueOf(entradaValue.getTipoEntrada().name()))
                .setEvento(org.f1.asignadorpais.avro.Evento.valueOf(entradaValue.getEvento().name()))
                .setPrecio(300.0)
                .setPais(paisProducer.obtenerPaisPorEvento(entradaValue.getEvento().toString())) // Validamos que obtiene el país correctamente
                .build();

        // Verificamos que KafkaTemplate.send() fue llamado con los valores correctos
        verify(kafkaTemplate, times(1)).send("asignacion-pais", expectedKey, expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
            "MONZA, Italia",
            "MONACO, Francia",
            "SILVERSTONE, Reino Unido",
            "SPA, Bélgica",
            "AUSTRALIA, Desconocido"
    })
    public void testObtenerPaisPorEvento(String evento, String expectedPais) {
        PaisProducer paisProducer = new PaisProducer();
        assertEquals(expectedPais, paisProducer.obtenerPaisPorEvento(evento));
    }
}

