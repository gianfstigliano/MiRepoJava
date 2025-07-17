package com.hiberus.servicios;

import com.hiberus.dto.PizzaReadDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicioPizzaRead {

    List<PizzaReadDTO> listarPizzas();
    PizzaReadDTO obtenerPizzaPorId(Long id);


}
