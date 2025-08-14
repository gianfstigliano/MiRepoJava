package org.f1.receptorasignador.repository;

import org.f1.asignadorpais.avro.Evento;
import org.f1.receptorasignador.model.Entrada;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntradaRepository extends MongoRepository<Entrada, Long> {
    Entrada findByIdUsuarioAndEvento(String idUsuario, Evento evento);
    List<Entrada> findByEvento(Evento evento);
}