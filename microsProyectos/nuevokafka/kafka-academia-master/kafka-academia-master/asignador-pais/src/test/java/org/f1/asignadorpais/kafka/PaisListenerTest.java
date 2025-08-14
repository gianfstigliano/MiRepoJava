package org.f1.asignadorpais.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;


import org.f1.enviadorentradas.avro.EntradaKey;
import org.f1.enviadorentradas.avro.EntradaValue;
import org.f1.enviadorentradas.avro.Evento;
import org.f1.enviadorentradas.avro.TipoEntrada;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.UUID;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PaisListenerTest {

    @InjectMocks
    private PaisListener paisListener; // Instanciamos el listener

    @Mock
    private PaisProducer paisProducer; // Mockeamos el producer

    @Test
    public void testProcess() {
        // Simulamos un mensaje de Kafka
        EntradaKey entradaKey = new EntradaKey(UUID.randomUUID().toString());
        EntradaValue entradaValue = new EntradaValue(entradaKey.getIdUsuario(), TipoEntrada.VIP, Evento.MONZA,"Italia", 300.0);

        ConsumerRecord<EntradaKey, EntradaValue> consumerRecord =
                new ConsumerRecord<>("entradas", 0, 0L, entradaKey, entradaValue);

        // Llamamos al método que procesa el mensaje
        paisListener.process(consumerRecord);

        verify(paisProducer, times(1)).send(entradaKey, entradaValue);
    }
}

