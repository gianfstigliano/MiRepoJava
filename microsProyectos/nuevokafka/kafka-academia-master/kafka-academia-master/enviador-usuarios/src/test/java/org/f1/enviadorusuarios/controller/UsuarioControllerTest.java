package org.f1.enviadorusuarios.controller;

import org.f1.enviadorusuarios.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UsuarioService usuarioService; // Mock del servicio

    @InjectMocks
    private UsuarioController usuarioController; // Controlador real

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build(); // Configuramos MockMvc para el controlador
    }

    @Test
    public void testCrearUsuario() throws Exception {
        // Dado un nombre y un mail, queremos verificar que el controlador funcione correctamente

        String nombre = "Gian";
        String mail = "g.stig@mail.com";
        String usuarioId = "12345"; // ID de usuario simulado

        // Mockear la respuesta del servicio
        when(usuarioService.crear(nombre, mail)).thenReturn(usuarioId);

        // Realizamos la solicitud POST al endpoint /usuarios
        mockMvc.perform(post("/usuarios")
                        .param("nombre", nombre)
                        .param("mail", mail)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)) // Especificamos que es un formulario
                .andExpect(status().isCreated()) // Verificamos que el estado de la respuesta sea 201 (CREATED)
                .andExpect(content().string("Usuario creado exitosamente: " + usuarioId)); // Verificamos el cuerpo de la respuesta

        // Verificamos que el método `crear` de `usuarioService` fue llamado una vez con los parámetros correctos
        verify(usuarioService, times(1)).crear(nombre, mail);
    }
}

