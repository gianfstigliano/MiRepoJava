package app.gui.paneles.turno;

import app.gui.PanelManager;
import app.gui.util.BotoneraAceptarCancelar;
import app.gui.util.BotoneraListadoCrud;
import exceptions.ServicioException;

import java.awt.*;
import javax.swing.*;

import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.MedicoService;
import service.PacienteService;
import service.TurnoService;

public class ListarTurnos extends JPanel implements ActionListener, Printable {

    private PanelManager m;
    private TurnoTableModel modelo;

    private JTable tablaTurnos;
    private JScrollPane scrollPaneParaTabla;
    private JButton botonLlenar;
    private BotoneraListadoCrud botoneraListadoCrud;
    private List<Object> listado = new ArrayList<Object>();

    public void setListado(List<Object> listado) {
        this.listado = listado;
    }

    public ListarTurnos(PanelManager m) {
        this.m = m;
        armarListarTurnos();
    }

    public void armarListarTurnos() {

        this.setLayout(new FlowLayout());

        modelo = new TurnoTableModel(listado);
        tablaTurnos = new JTable(modelo);
        scrollPaneParaTabla = new JScrollPane(tablaTurnos);
        this.add(scrollPaneParaTabla);

        botonLlenar = new JButton("Cargar Tabla");
        botonLlenar.addActionListener(this);
        this.add(botonLlenar);

        botoneraListadoCrud = new BotoneraListadoCrud(m){

            @Override
            protected void goModificar() {
                m.mostrarPantallaMODIFICARTurno();
            }

            @Override
            protected void goCrear() {
                m.mostrarPantallaCREARTurno();
            }

            @Override
            protected void goBuscar() {
                m.mostrarPantallaBUSCARTurno();
            }

            @Override
            protected void goBorrar() {
                m.mostrarPantallaBORRARTurno();
            }

            @Override
            protected void doCancel() {
                m.mostrarPantallaTurno();
            }
        };

        this.add(botoneraListadoCrud);
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        System.out.println("imprimo");
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            List<Object> listado_turnos = TurnoService.listarTurnos();
            modelo.setContenido(listado_turnos);
            JOptionPane.showMessageDialog(this, "Se listo los Turnos con exito!",
                    "Listando Turnos", JOptionPane.INFORMATION_MESSAGE);
        } catch (ServicioException e1) {
            JOptionPane.showMessageDialog(this, "Hubo un problema al listar los Turnos",
                    "Error Interno", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }
        modelo.fireTableDataChanged();
    }

}
