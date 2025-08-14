package org.f1.enviadorusuarios.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.f1.enviadorusuarios.avro.UsuarioKey;
import org.f1.enviadorusuarios.avro.UsuarioValue;
import org.f1.enviadorusuarios.dto.UsuarioDTO;
import org.f1.enviadorusuarios.mapper.UsuarioKeyMapper;
import org.f1.enviadorusuarios.mapper.UsuarioValueMapper;
import org.f1.enviadorusuarios.model.Usuario;
import org.f1.enviadorusuarios.repository.UsuarioRepository;
import org.f1.enviadorusuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    @Value("${environment.usuario-topic}")
    private String UsuarioTopic;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private KafkaTemplate<UsuarioKey, UsuarioValue> kafkaTemplate;


    @Override
    public String crear(String nombre, String mail ) {
        if( nombre.isBlank() || mail.isBlank() ) {
            log.error("El usuario es nulo o está incompleto.");
            throw new IllegalArgumentException("El usuario esta incompleto");
        }

        if (usuarioRepository.existsByMail(mail)) { // Cambio en el nombre del método
            throw new IllegalArgumentException("Ya existe un usuario con el mail " + mail);
        }

        UUID id = UUID.randomUUID();

        // Crear la entidad Usuario en lugar de UsuarioDTO
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setMail(mail);

        // Guardar la entidad en la base de datos
        usuarioRepository.save(usuario);

        // Convertir Usuario a DTO para Kafka
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(id);
        usuarioDTO.setNombre(nombre);
        usuarioDTO.setMail(mail);

        UsuarioKey key = new UsuarioKeyMapper().dtoToEntity(usuarioDTO);
        UsuarioValue value = new UsuarioValueMapper().dtoToEntity(usuarioDTO);

        log.debug("Enviando el usuario al topic de kafka");
        kafkaTemplate.send(UsuarioTopic, key, value);

        return id.toString();
    }

}
