/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hibernate.jpa1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Giani
 */

@Getter @Setter
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idVehiculo;
    private String tipo;
    private String marca;
    private String modelo;

    public Vehiculo() {
    }
    
    public Vehiculo(Long idVehiculo, String tipo, String marca, String modelo) {
        this.idVehiculo = idVehiculo;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
    }
    
}
