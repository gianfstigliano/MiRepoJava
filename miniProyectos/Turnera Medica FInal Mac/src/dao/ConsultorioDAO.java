package dao;

import java.util.List;

import exceptions.DAOException;
import entidades.Consultorio;

public interface ConsultorioDAO {

    void crearConsultorio(Consultorio c) throws DAOException;

    void borrarConsultorio(String nombre) throws DAOException;

    void modificarConsultorio(String nombre, String direccion) throws DAOException;

    List<Object> listarConsultorios() throws DAOException;

    List<Object> consultarConsultorio(String nombre) throws DAOException;
}
