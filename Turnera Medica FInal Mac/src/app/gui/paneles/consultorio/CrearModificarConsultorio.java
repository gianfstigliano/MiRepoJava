package app.gui.paneles.consultorio;

import javax.swing.*;
import java.awt.*;

import app.gui.PanelManager;
import app.gui.util.BotoneraAceptarCancelar;
import app.gui.util.CampoLabelField;

public abstract class CrearModificarConsultorio extends JPanel {

    protected PanelManager m;
    protected CampoLabelField nombre, direccion;
    private BotoneraAceptarCancelar botoneraAceptarCancelar;

    public CrearModificarConsultorio(PanelManager m) {
        this.m = m;
        armarCrearModificarConsultorio();
    }

    private void armarCrearModificarConsultorio() {

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        nombre = new CampoLabelField(m, "Nombre");
        this.add(nombre);

        direccion = new CampoLabelField(m, "Direccion");
        this.add(direccion);

        botoneraAceptarCancelar = new BotoneraAceptarCancelar(m, "Aceptar"){

            @Override
            protected void doCancel() {
                m.mostrarPantallaConsultorio();
            }

            @Override
            protected void doAccept() {
                ejecutar();
            }

        };
        this.add(botoneraAceptarCancelar);


    }

    protected abstract void ejecutar();


}
