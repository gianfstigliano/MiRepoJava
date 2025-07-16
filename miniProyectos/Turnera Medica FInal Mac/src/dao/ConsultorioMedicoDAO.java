package dao;

import java.util.List;

import exceptions.DAOException;
import entidades.ConsultorioMedico;

public interface ConsultorioMedicoDAO {

    void crearConsultorioMedico(ConsultorioMedico cm) throws DAOException;

    void borrarConsultorioMedico(int id_consultorio, int medico_dni) throws DAOException;

    void modificarConsultorioMedico(ConsultorioMedico cm) throws DAOException;

    List<Object> listarConsultoriosMedicos() throws DAOException;

    List<Object> consultarConsultorioMedico(int nombre_consultorio, int medico_dni) throws DAOException;

    List<Object> consultarConsultorioMedicoFecha(int medico_dni, String fecha) throws DAOException;
}
