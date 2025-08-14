package org.f1.enviadorusuarios.service;

import org.f1.enviadorusuarios.avro.UsuarioKey;
import org.f1.enviadorusuarios.avro.UsuarioValue;
import org.f1.enviadorusuarios.model.Usuario;
import org.f1.enviadorusuarios.repository.UsuarioRepository;
import org.f1.enviadorusuarios.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private KafkaTemplate<UsuarioKey, UsuarioValue> kafkaTemplate;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    private String nombre;
    private String mail;

    private String nombreVacio;
    private String mailVacio;

    @BeforeEach
    void setUp() {
        nombre = "Gian";
        mail = "g.stig@example.com";
        nombreVacio= " ";
        mailVacio=" ";
    }

    @Test
    void crearUsuarioExitoso() {
        // Configurar el mock para que el mail no exista en la base de datos
        when(usuarioRepository.existsByMail(mail)).thenReturn(false);
        when(usuarioRepository.save(any(Usuario.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Ejecutar el método
        String usuarioId = usuarioService.crear(nombre, mail);

        // Verificar que se haya guardado el usuario
        verify(usuarioRepository).save(any(Usuario.class));
        //verify(kafkaTemplate).send(anyString(), any(UsuarioKey.class), any(UsuarioValue.class));

        // Asegurar que el ID devuelto no es nulo
        assertNotNull(usuarioId);
    }

    @Test
    void crearUsuarioEmailExistenteLanzaExcepcion() {
        when(usuarioRepository.existsByMail(mail)).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.crear(nombre, mail);
        });

        assertEquals("Ya existe un usuario con el mail " + mail, exception.getMessage());

        // Verificar que nunca se guardó el usuario
        verify(usuarioRepository, never()).save(any(Usuario.class));
        verify(kafkaTemplate, never()).send(anyString(), any(UsuarioKey.class), any(UsuarioValue.class));
    }

    @Test
    void crearUsuarioBlank(){
        //Nombre Vacio
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.crear(nombreVacio, mail);
        });

        assertEquals("El usuario esta incompleto", exception.getMessage());

        //Mail Vacio
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.crear(nombre, mailVacio);
        });

        assertEquals("El usuario esta incompleto", exception1.getMessage());

        // Verificar que no se interactuó con el repositorio ni con Kafka
        verifyNoInteractions(usuarioRepository);


    }

}




