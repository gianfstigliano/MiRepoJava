package app.gui.paneles.medico;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import app.gui.PanelManager;
import app.gui.util.BotoneraAceptarCancelar;
import app.gui.util.CampoLabelField;
import exceptions.ServicioException;
import service.MedicoService;

public class BuscarMedico extends JPanel {

    private PanelManager m;
    private CampoLabelField dni;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public BuscarMedico(PanelManager m) {
        this.m = m;
        armarBuscarMedico();
    }

    private void armarBuscarMedico() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        dni = new CampoLabelField(m, "DNI");
        this.add(dni);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Crear") {

            @Override
            protected void doCancel() {
                m.mostrarPantallaMedicos();
            }

            @Override
            protected void doAccept() {
                String dni_txt = dni.getCampo().getText();
                try {
                    List<Object> medico_consultado = MedicoService.consultarMedico(dni_txt);
                    if (medico_consultado.size() > 0) {
                        JOptionPane.showMessageDialog(this,
                                "DNI: " + ((List<Object>) medico_consultado.get(0)).get(0) + "\n" +
                                        "Nombre: " + ((List<Object>) medico_consultado.get(0)).get(1) + "\n" +
                                        "Apellido: " + ((List<Object>) medico_consultado.get(0)).get(2) + "\n" +
                                        "Fecha de nacimiento: " + ((List<Object>) medico_consultado.get(0)).get(3) + "\n" +
                                        "Monto de consulta: " + ((List<Object>) medico_consultado.get(0)).get(4) + "\n" +
                                        "Listado de Obra Social: " + ((List<Object>) medico_consultado.get(0)).get(5),
                                "Medico encontrado!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se encontro el medico con ese dni",
                                "Medico no encontrado", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ServicioException e) {
                    JOptionPane.showMessageDialog(this, "Hubo un problema al listar los medicos",
                            "Error Interno", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }

        };
        this.add(botoneraAceptarCancelar);

    }

}