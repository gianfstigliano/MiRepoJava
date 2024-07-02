package dao;

import java.sql.Date;
import java.util.List;

import exceptions.DAOException;
import entidades.Turno;

public interface TurnoDAO {

    void crearTurno(Turno t) throws DAOException;

    void borrarTurno(String medico_dni, String paciente_dni) throws DAOException;

    void modificarTurno(Turno t) throws DAOException;

    List<Object> listarTurnos() throws DAOException;

    List<Object> consultarTurnoMedico(String medico_dni) throws DAOException;

    List<Object> consultarTurnoPaciente(String paciente_dni) throws DAOException;

    List<Object> consultarTurnoMedicoFecha(String medico_dni, Date fecha) throws DAOException;

    List<Object> consultarHorarioTurnoMedico(int medico_dni, String hora_turno) throws DAOException;

    List<Object> consultarFacturacionMedico(int medico_dni, String fecha_desde, String fecha_hasta) throws DAOException;
}
