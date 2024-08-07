package app.gui.paneles.medico;

import javax.swing.JOptionPane;

import app.gui.PanelManager;
import exceptions.ServicioException;
import service.MedicoService;

public class CrearMedico extends CrearModificarMedico {

    public CrearMedico(PanelManager m) {
        super(m);
    }

    @Override
    protected void ejecutar() {
        int dni = 0;
        String nombre = super.nombre.getCampo().getText();
        String apellido = super.apellido.getCampo().getText();
        int ano = 0, mes = 0, dia = 0;
        float montoConsulta = 0;
        try {
            dni = Integer.parseInt(super.dni.getCampo().getText());
            ano = Integer.parseInt(super.fecha_nacimiento.getCampo_ano().getText());
            mes = Integer.parseInt(super.fecha_nacimiento.getCampo_mes().getText());
            dia = Integer.parseInt(super.fecha_nacimiento.getCampo_dia().getText());
            montoConsulta = Float.parseFloat(super.montoConsulta.getCampo().getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, verifique que todos los campos nummericos no contengan letras", "Valor invalido",
                    JOptionPane.ERROR_MESSAGE);
        }

        String listadoObraSocial = super.listadoObraSocial.getCampo().getText();

        if (dni > 0 && nombre.length() > 0 && apellido.length() > 0 && ano > 1900 && ano < 2021 && mes > 0 && mes < 13
                && dia > 0 && dia < 32 && listadoObraSocial.length() > 0) {
            String fecha_nacimiento = String.valueOf(ano) + '-' + String.valueOf(mes) + '-' + String.valueOf(dia);
            try {
                String respuesta = MedicoService.crearMedico(dni, nombre, apellido, fecha_nacimiento, montoConsulta, listadoObraSocial);
                int respuesta_joption = JOptionPane.showConfirmDialog(this, respuesta,
                        "Creando Medico", JOptionPane.OK_CANCEL_OPTION);
                if (respuesta_joption == JOptionPane.OK_OPTION) {
                    m.mostrarPantallaMedicos();
                }
            } catch (ServicioException e) {
                JOptionPane.showMessageDialog(this, "Hubo un problema al crear el medico",
                        "Error Interno", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();

            }
        } else {
            JOptionPane.showMessageDialog(this, "Verifica haber puesto bien todos los campos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }



    }

}
