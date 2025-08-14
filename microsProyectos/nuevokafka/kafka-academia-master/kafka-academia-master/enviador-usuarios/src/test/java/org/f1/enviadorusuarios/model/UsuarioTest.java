package org.f1.enviadorusuarios.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsuarioTest {
    @Test
    public void testUsuarioCreation() {
        // Crear una instancia de Usuario
        UUID usuarioId = UUID.randomUUID();
        String nombre = "Gian";
        String mail = "g.stig@example.com";

        Usuario usuario = new Usuario(usuarioId,nombre, mail);

        // Verificar que los valores se asignaron correctamente
        assertNotNull(usuario.getId());
        assertEquals(nombre, usuario.getNombre());
        assertEquals(mail, usuario.getMail());
    }


}
