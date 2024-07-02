package app.gui.util;

import javax.swing.*;
import java.awt.*;

public class CampoLabelField extends JPanel{

    private app.gui.PanelManager m;
    private JTextField campo;

    public CampoLabelField(app.gui.PanelManager m, String label) {
        this.m = m;
        armarCampoLabelField(label);
    }

    private void armarCampoLabelField(String label) {

        this.setLayout(new FlowLayout());

        JLabel nombreDelCampo = new JLabel(label);
        // nombreDelCampo.setPreferredSize(new Dimension(300, 60));
        this.add(nombreDelCampo);

        campo = new JTextField();
        campo.setPreferredSize(new Dimension(250, 30));
        this.add(campo);

    }

    public JTextField getCampo() {
        return campo;
    }

    public void setCampo(JTextField campo) {
        this.campo = campo;
    }
}
