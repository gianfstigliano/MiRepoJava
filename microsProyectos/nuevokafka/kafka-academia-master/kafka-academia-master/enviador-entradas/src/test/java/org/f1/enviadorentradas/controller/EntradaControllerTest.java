package org.f1.enviadorentradas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.f1.enviadorentradas.dto.EntradaCrearDTO;
import org.f1.enviadorentradas.enums.Evento;
import org.f1.enviadorentradas.enums.TipoEntrada;
import org.f1.enviadorentradas.service.EntradaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.UUID;


@WebMvcTest(EntradaController.class) // Carga solo el controlador
@ExtendWith(MockitoExtension.class)  // Habilita Mockito
public class EntradaControllerTest {

    @Autowired
    private MockMvc mockMvc; // Inyectamos MockMvc para hacer pruebas HTTP

    @MockBean
    private EntradaService entradaService; // Mockeamos el servicio

    @Autowired
    private ObjectMapper objectMapper; // Para convertir DTOs a JSON

    @Test
    public void testCrearEntrada() throws Exception {
        // Crear un DTO con datos válidos
        EntradaCrearDTO entradaCrearDTO = new EntradaCrearDTO();
        entradaCrearDTO.setIdUsuario(UUID.randomUUID());
        entradaCrearDTO.setTipoEntrada(TipoEntrada.VIP);
        entradaCrearDTO.setEvento(Evento.MONZA); // Usar directamente el enum

        // Simular que el servicio no lanza excepciones
        doNothing().when(entradaService).crear(any(EntradaCrearDTO.class));

        // Realizamos la solicitud POST al endpoint /entrada
        mockMvc.perform(post("/entrada")
                        .contentType(MediaType.APPLICATION_JSON) // Indica que el cuerpo es JSON
                        .content(objectMapper.writeValueAsString(entradaCrearDTO))) // Convertimos el DTO a JSON
                .andExpect(status().isAccepted()); // Verificamos que la respuesta sea 202 (ACCEPTED)

        // Verificamos que el método `crear` de `entradaService` fue llamado una vez con el objeto correcto
        verify(entradaService, times(1)).crear(any(EntradaCrearDTO.class));
    }
}



