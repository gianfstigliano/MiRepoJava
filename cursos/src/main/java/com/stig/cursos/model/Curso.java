/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stig.cursos.model;

import jakarta.persistence.Entity;
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
    private Long idCurso;
    private String nombre;
    private String modalidad;
    private Date fechaFinalizacion;
    private List<Tema> listaTemas;
}
