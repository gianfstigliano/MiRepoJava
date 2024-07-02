package dao;

import java.util.List;

import exceptions.DAOException;
import entidades.Medico;

public interface MedicoDAO {

    void crearMedico(Medico m) throws DAOException;

    void borrarMedico(String medico_dni) throws DAOException;

    void modificarMedico(Medico m) throws DAOException;

    List<Object> listarMedicos() throws DAOException;

    List<Object> consultarMedico(String dni) throws DAOException; //POR AHORA SOLO SE VA A PODER BUSCAR POR DNI Y NO POR NOMBRE O/Y APELLIDO
}
