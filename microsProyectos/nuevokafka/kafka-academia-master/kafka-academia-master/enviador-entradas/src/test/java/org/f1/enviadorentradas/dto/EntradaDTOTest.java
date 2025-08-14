package org.f1.enviadorentradas.dto;

import org.f1.enviadorentradas.enums.Evento;
import org.f1.enviadorentradas.enums.TipoEntrada;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EntradaDTOTest {


    @ParameterizedTest
    @EnumSource(Evento.class) // Prueba con todos los valores del enum Evento
    void testEventoAsignadoCorrectamente(Evento evento) {
        // Arrange
        EntradaDTO entradaDTO = new EntradaDTO();

        // Act
        entradaDTO.setEvento(evento);

        // Assert
        assertNotNull(entradaDTO.getEvento(), "El evento no debería ser nulo");
        assertEquals(evento, entradaDTO.getEvento(), "El evento asignado no coincide con el esperado");
    }

    @ParameterizedTest
    @EnumSource(TipoEntrada.class) // Prueba con todos los valores del enum Evento
    void testTipoEntradaAsignadaCorrectamente(TipoEntrada tipoEntrada) {
        // Arrange
        EntradaDTO entradaDTO = new EntradaDTO();

        // Act
        entradaDTO.setTipoEntrada(tipoEntrada);

        // Assert
        assertNotNull(entradaDTO.getTipoEntrada(), "El tipo entrada no debería ser nulo");
        assertEquals(tipoEntrada, entradaDTO.getTipoEntrada(), "El tipo entrada asignado no coincide con el esperado");
    }
}
