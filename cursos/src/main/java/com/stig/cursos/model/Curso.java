/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stig.cursos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Giani
 */
@Getter @Setter
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idCurso;
    private String nombre;
    private String modalidad;
    private Date fechaFinalizacion;
    @OneToMany
    private List<Tema> listaTemas;

    public Curso() {
    }

    public Curso(Long idCurso, String nombre, String modalidad, Date fechaFinalizacion, List<Tema> listaTemas) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.fechaFinalizacion = fechaFinalizacion;
        this.listaTemas = listaTemas;
    }
    
    
}
