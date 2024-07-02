package app.gui.paneles.paciente;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import app.gui.PanelManager;
import app.gui.util.BotoneraAceptarCancelar;
import app.gui.util.CampoLabelField;
import exceptions.ServicioException;
import service.PacienteService;

public class BuscarPaciente extends JPanel {

    private PanelManager m;
    private CampoLabelField dni;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public BuscarPaciente(PanelManager m) {
        this.m = m;
        armarBuscarPaciente();
    }

    private void armarBuscarPaciente() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        dni = new CampoLabelField(m, "DNI");
        this.add(dni);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Buscar") {

            @Override
            protected void doCancel() {
                m.mostrarPantallaPaciente();
            }

            @Override
            protected void doAccept() {
                String dni_txt = dni.getCampo().getText();
                try {
                    List<Object> paciente_consultado = PacienteService.consultarPaciente(dni_txt);
                    if (paciente_consultado.size() > 0) {
                        JOptionPane.showMessageDialog(this,
                                "DNI: " + ((List<Object>) paciente_consultado.get(0)).get(0) + "\n" +
                                        "Nombre: " + ((List<Object>) paciente_consultado.get(0)).get(1) + "\n" +
                                        "Apellido: " + ((List<Object>) paciente_consultado.get(0)).get(2) + "\n" +
                                        "Fecha de nacimiento: " + ((List<Object>) paciente_consultado.get(0)).get(3) + "\n" +
                                        "Obra Social: " + ((List<Object>) paciente_consultado.get(0)).get(4),
                                "Paciente encontrado!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se encontro el paciente con ese dni",
                                "Paciente no encontrado", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ServicioException e) {
                    JOptionPane.showMessageDialog(this, "Hubo un problema al consultar el paciente",
                            "Error Interno", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }

        };
        this.add(botoneraAceptarCancelar);

    }

}