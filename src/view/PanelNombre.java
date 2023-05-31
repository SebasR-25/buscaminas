package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelNombre extends JPanel {
    private JLabel nombreLabel;
    private JTextField nombreField;
    private JComboBox<String> dificultades;
    private JButton continuarButton;
    private final String[] dificultadesVector = {"Facil","Medio","Dificil"};

    public PanelNombre(ActionListener actionListener){
        setLayout(null);
        initComp(actionListener);
        ubicateComp();
        addComp();
        setVisible(true);
    }

    private void initComp(ActionListener actionListener){
        nombreLabel = new JLabel("Ingrese su nombre");
        nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombreField = new JTextField();
        dificultades = new JComboBox<>(dificultadesVector);
        continuarButton = new JButton("Continuar");
        continuarButton.addActionListener(actionListener);
        continuarButton.setActionCommand("CONTINUAR");
    }
    private void ubicateComp(){
        nombreLabel.setBounds(190, 140, 120, 20);
        nombreField.setBounds(200, 160, 100, 20);
        dificultades.setBounds(210, 250, 80, 20);
        continuarButton.setBounds(200, 340, 100, 20);
    }
    private void addComp(){
        add(nombreLabel);
        add(nombreField);
        add(dificultades);
        add(continuarButton);
    }

    public JTextField getNombreField() {
        return nombreField;
    }

    public void setNombreField(JTextField nombreField) {
        this.nombreField = nombreField;
    }

    public JComboBox<String> getDificultades() {
        return dificultades;
    }

    public void setDificultades(JComboBox<String> dificultades) {
        this.dificultades = dificultades;
    }
}
