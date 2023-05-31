package view;

import javax.swing.*;

public class PanelNombre extends JPanel {
    private JLabel nombreLabel;
    private JTextField nombreField;
    private JComboBox<String> dificultades;
    private JButton continuarButton;
    private final String[] dificultadesVector = {"Facil","Medio","Difícil"};

    public PanelNombre(){
        setLayout(null);
        initComp();
        ubicateComp();
        addComp();
        setVisible(true);
    }

    private void initComp(){
        nombreLabel = new JLabel("Ingrese su nombre");
        nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombreField = new JTextField();
        dificultades = new JComboBox<>(dificultadesVector);
        continuarButton = new JButton("Continuar");
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
}
