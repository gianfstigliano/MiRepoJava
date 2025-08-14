package org.f1.enviadorusuarios.repository;


import org.f1.enviadorusuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    boolean existsByMail(String mail);
}
