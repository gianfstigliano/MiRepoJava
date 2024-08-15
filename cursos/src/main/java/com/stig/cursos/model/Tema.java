/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stig.cursos.model;

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
public class Tema {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idTema;
    private String nombre;
    private String descripcion;

    public Tema() {
    }

    public Tema(Long idTema, String nombre, String descripcion) {
        this.idTema = idTema;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    
}
