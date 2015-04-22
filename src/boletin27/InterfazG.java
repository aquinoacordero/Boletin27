/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin27;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oquintansocampo
 */
public class InterfazG implements ActionListener {

    JFrame marco;
    JPanel panel, panelA, panelB, panelC;
    JButton boton;
    JTextField nombreF, apellidoF;
    JLabel nombreL, apellidoL;
    JComboBox curso;
    JTable tabla;
    JScrollPane scroll;
    DefaultTableModel dtm;
    String[][] datos;
    String[] campos = {"NOMBRE", "APELLIDOS", "CURSO"};

    public InterfazG() {
        marco = new JFrame();
        panel = new JPanel();
        panel.add(this.crearPanelA());
        panel.add(this.crearPanelB());
        panel.add(this.crearPanelC());
        marco.add(panel);
        marco.setSize(400, 400);
        marco.setResizable(false);
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JPanel crearPanelA() {
        nombreL = new JLabel("NOMBRE ");
        nombreF = new JTextField(10);
        curso = new JComboBox();
        panelA = new JPanel();
        panelA.setBounds(0, 0, 400, 50);
        curso.addItem("dam1");
        curso.addItem("dam2");
        curso.addItem("asir1");
        curso.addItem("asir2");

        panelA.add(nombreL);
        panelA.add(nombreF);
        panelA.add(curso);

        return panelA;
    }

    public JPanel crearPanelB() {
        apellidoL = new JLabel("APELLIDO ");
        apellidoF = new JTextField(10);
        boton = new JButton("AGREGAR TABLA ");
        boton.addActionListener(this);
        panelB = new JPanel();
        panelB.setBounds(0, 50, 400, 75);
        panelB.add(apellidoL);
        panelB.add(apellidoF);
        panelB.add(boton);

        return panelB;
    }

    public JPanel crearPanelC() {
        panelC = new JPanel();
        panelC.setBounds(0, 100, 400, 300);
        dtm = new DefaultTableModel(datos, campos);
        tabla = new JTable(dtm);
        scroll = new JScrollPane(tabla);
        dtm.addRow(campos);
        tabla.setEnabled(false);

        tabla.add(scroll.createVerticalScrollBar());
        panelC.add(tabla);

        return panelC;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) {
            String[] fila = {nombreF.getText(), apellidoF.getText(), curso.getSelectedItem().toString()};
            dtm.addRow(fila);
        }
    }
}
