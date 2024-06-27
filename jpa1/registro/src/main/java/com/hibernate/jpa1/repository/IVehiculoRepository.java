/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hibernate.jpa1.repository;

import com.hibernate.jpa1.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Giani
 */
public interface IVehiculoRepository extends JpaRepository <Vehiculo, Long> {
    
}
