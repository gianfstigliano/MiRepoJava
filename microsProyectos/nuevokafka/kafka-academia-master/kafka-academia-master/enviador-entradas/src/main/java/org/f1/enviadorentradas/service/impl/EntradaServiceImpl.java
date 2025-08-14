package org.f1.enviadorentradas.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.f1.enviadorentradas.avro.EntradaKey;
import org.f1.enviadorentradas.avro.EntradaValue;
import org.f1.enviadorentradas.dto.EntradaCrearDTO;
import org.f1.enviadorentradas.dto.EntradaDTO;
import org.f1.enviadorentradas.enums.TipoEntrada;
import org.f1.enviadorentradas.mapper.EntradaKeyMapper;
import org.f1.enviadorentradas.mapper.EntradaValueMapper;
import org.f1.enviadorentradas.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EntradaServiceImpl implements EntradaService {

    @Value("${environment.entrada-topic}")
    private String EntradaTopic;

    @Autowired
    private KafkaTemplate<EntradaKey, EntradaValue> kafkaTemplate;

    public double calcularPrecio(TipoEntrada tipoEntrada) {
        if (tipoEntrada == TipoEntrada.VIP) {
            return 200.0;
        }
        return 100.0; // Precio por defecto para GENERAL
    }

    @Override
    public void crear(EntradaCrearDTO entradaCrearDTO) {
        if (entradaCrearDTO == null || entradaCrearDTO.getIdUsuario() == null) {
            log.error("La entrada es nula.");
            return;
        }



        EntradaDTO entradaDTO = new EntradaDTO();
        entradaDTO.setIdUsuario(entradaCrearDTO.getIdUsuario());
        entradaDTO.setTipoEntrada(entradaCrearDTO.getTipoEntrada());
        entradaDTO.setEvento(entradaCrearDTO.getEvento());
        entradaDTO.setPais(null);


        Double precio = calcularPrecio(entradaDTO.getTipoEntrada());
        entradaDTO.setPrecio(precio);




        EntradaKey key = new EntradaKeyMapper().dtoToEntity(entradaDTO);
        EntradaValue value = new EntradaValueMapper().dtoToEntity(entradaDTO);

        log.debug("Enviando la entrada al topic de Kafka");
        kafkaTemplate.send(EntradaTopic, key, value);
    }



}