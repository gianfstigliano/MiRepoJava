package com.hiberus.clientes;

import com.hiberus.dto.PizzaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pizza-read")
public interface ClientePizza {

    @GetMapping("/pizzas/read/{id}")
    PizzaDto obtenerPizzaPorId(@PathVariable Long id);
}


