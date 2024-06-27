/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hibernate.jpa1.controller;

import com.hibernate.jpa1.model.Vehiculo;
import com.hibernate.jpa1.service.IVehiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Giani
 */
@RestController
public class VehiculoController {
    
    @Autowired
    private IVehiculoService vehiculoServ;
    
    @GetMapping("/vehiculos/traer")
    public List<Vehiculo> getVehiculos(){
        return vehiculoServ.getVehiculos();
    }
    
    @PostMapping("/vehiculo/crear")
    public String saveVehiculo(@RequestBody Vehiculo vehiculo){
        vehiculoServ.saveVehiculo(vehiculo);
        return "El vehiculo fue creado correctamente";
    }
}
