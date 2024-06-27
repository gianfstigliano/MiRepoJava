/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hibernate.jpa1.service;

import com.hibernate.jpa1.model.Vehiculo;
import com.hibernate.jpa1.repository.IVehiculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Giani
 */
public class VehiculoService implements IVehiculoService {
    
    @Autowired
    private IVehiculoRepository vehiculoRepo;

    @Override
    public List<Vehiculo> getVehiculos() {
        
        List<Vehiculo> listaVehiculos = vehiculoRepo.findAll();
        return listaVehiculos;     
    }

    @Override
    public void saveVehiculo(Vehiculo vehiculo) {
        vehiculoRepo.save(vehiculo);
    }

    @Override
    public void deleteVehiculo(Long idVehiculo) {
        vehiculoRepo.deleteById(idVehiculo);
    }

    @Override
    public Vehiculo findVehiculo(Long idVehiculo) {
        Vehiculo vehiculo = vehiculoRepo.findById(idVehiculo).orElse(null);
        return vehiculo;
    }

    @Override
    public void editVehiculo(Long idOriginal, Long idNueva, String nuevoTipo, String nuevaMarca, String nuevoModelo) {
            
//busco  el objeto original
            Vehiculo vehiculo = this.findVehiculo(idOriginal);
            
            //proceso de modificación a nivel lógico
            vehiculo.setIdVehiculo(idNueva);
            vehiculo.setTipo(nuevoTipo);
            vehiculo.setMarca(nuevaMarca);
            vehiculo.setModelo(nuevoModelo);
            
            //guardar los cambios
            this.saveVehiculo(vehiculo);
    }

    @Override
    public void editVehiculo(Vehiculo vehiculo) {
        this.saveVehiculo(vehiculo);
    }

    
}
