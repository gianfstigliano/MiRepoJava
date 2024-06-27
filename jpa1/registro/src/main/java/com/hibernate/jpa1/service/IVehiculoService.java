/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hibernate.jpa1.service;

import com.hibernate.jpa1.model.Vehiculo;
import java.util.List;

/**
 *
 * @author Giani
 */
public interface IVehiculoService {
    //método para traer a todas las personas
    //lectura
    public List<Vehiculo> getVehiculos();

    //alta
    public void saveVehiculo(Vehiculo vehiculo);

    //baja
    public void deleteVehiculo(Long idVehiculo);

    //lectura de un solo objeto
    public Vehiculo findVehiculo(Long idVehiculo);

    //edición/modificación
    public void editVehiculo(Long idOriginal, Long idNueva,
                            String nuevoTipo,
                            String nuevaMarca,
                            String nuevoModelo);

    public void editVehiculo(Vehiculo vehiculo);
    
}

