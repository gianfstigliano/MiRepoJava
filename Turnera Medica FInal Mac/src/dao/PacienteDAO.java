package dao;

import java.util.List;

import exceptions.DAOException;
import entidades.Paciente;

public interface PacienteDAO {

    void crearPaciente(Paciente m) throws DAOException;

    void borrarPaciente(String dni) throws DAOException;

    void modificarPaciente(Paciente m) throws DAOException;

    List<Object> listarPacientes() throws DAOException;

    List<Object> consultarPaciente(String dni) throws DAOException; //POR AHORA SOLO SE VA A PODER BUSCAR POR DNI Y NO POR NOMBRE O/Y APELLIDO
}
