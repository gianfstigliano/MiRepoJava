/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hibernate.jpa1.service;

import com.hibernate.jpa1.model.Persona;
import java.util.List;

/**
 *
 * @author Giani
 */
public interface IPersonaService {
    
    
    public List<Persona> getPersonas();

    
    public void savePersona(Persona perso);

    
    public void deletePersona(Long id);

    
    public Persona findPersona(Long id);

    
    public void editPersona(Long idOriginal, Long idNueva,
                            String nuevoNombre,
                            String nuevoApellido,
                            int nuevaEdad);

    public void editPersona(Persona perso);
    
}
