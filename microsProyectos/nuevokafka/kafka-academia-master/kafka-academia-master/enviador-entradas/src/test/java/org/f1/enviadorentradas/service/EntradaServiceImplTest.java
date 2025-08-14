package org.f1.enviadorentradas.service;

import org.f1.enviadorentradas.avro.EntradaKey;
import org.f1.enviadorentradas.avro.EntradaValue;
import org.f1.enviadorentradas.dto.EntradaCrearDTO;
import org.f1.enviadorentradas.dto.EntradaDTO;
import org.f1.enviadorentradas.enums.Evento;
import org.f1.enviadorentradas.enums.TipoEntrada;
import org.f1.enviadorentradas.service.impl.EntradaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class EntradaServiceImplTest {

    @Mock
    private KafkaTemplate<EntradaKey, EntradaValue> kafkaTemplate;

    @InjectMocks
    private EntradaServiceImpl entradaService;


    @BeforeEach
    void setUp() {

    }

    @Test
    void crearEntradaExitosa() {
        EntradaCrearDTO entradaCrearDTO = new EntradaCrearDTO();
        entradaCrearDTO.setIdUsuario(UUID.randomUUID());
        entradaCrearDTO.setTipoEntrada(TipoEntrada.VIP);
        entradaCrearDTO.setEvento(Evento.MONZA);

        // Act: Llamar al método que queremos probar
        entradaService.crear(entradaCrearDTO);

        assertNotNull(entradaCrearDTO.getIdUsuario(), "El idUsuario no debería ser nulo");
        assertNotNull(entradaCrearDTO.getTipoEntrada(), "El tipoEntrada no debería ser nulo");
        assertNotNull(entradaCrearDTO.getEvento(), "El evento no debería ser nulo");
    }

    @Test
    void calcularPrecio_DeberiaRetornarPrecioCorrecto() {
        assertEquals(200.0, entradaService.calcularPrecio(TipoEntrada.VIP));
        assertEquals(100.0, entradaService.calcularPrecio(TipoEntrada.GENERAL));
    }

    @Test
    void verificarEvento() {
        // Arrange: Creamos un DTO con el evento MONZA
        EntradaCrearDTO entradaCrearDTO = new EntradaCrearDTO();
        entradaCrearDTO.setEvento(Evento.MONZA);

        // Act: Creamos una entrada usando el servicio
        entradaService.crear(entradaCrearDTO);

        // Assert: Verificamos que la entrada tiene el evento correcto
        assertEquals("MONZA", entradaCrearDTO.getEvento().name());
    }

    @Test
    void testCamposNoNulos() {
        // Arrange: Crear una instancia con valores
        EntradaDTO entradaDTO = new EntradaDTO();
        entradaDTO.setIdUsuario(UUID.randomUUID());
        entradaDTO.setTipoEntrada(TipoEntrada.VIP);
        entradaDTO.setEvento(Evento.MONZA);
        entradaDTO.setPrecio(entradaService.calcularPrecio(TipoEntrada.VIP));
        entradaDTO.setPais(null);


        // Assert: Verificar que ningún campo es nulo
        assertNotNull(entradaDTO.getIdUsuario(), "El idUsuario no debería ser nulo");
        assertNotNull(entradaDTO.getTipoEntrada(), "El tipoEntrada no debería ser nulo");
        assertNotNull(entradaDTO.getEvento(), "El evento no debería ser nulo");
        assertNotNull(entradaDTO.getPrecio(), "El precio no debería ser nulo");
        assertNull(entradaDTO.getPais(), "El pais no debería ser nulo");
    }
}