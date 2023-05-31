package view;

import javax.swing.*;

public class PanelInicio extends JPanel{
    private JButton jugarButton;
    private JButton historialButton;

    public PanelInicio(){
        setLayout(null);
        initButtons();
        ubicateButtons();
        addButtons();
        setVisible(true);
    }

    private void initButtons(){
        jugarButton = new JButton("JUGAR");
        historialButton = new JButton("HISTORIAL");
    }
    private void ubicateButtons(){
        jugarButton.setBounds(200, 140, 100, 40);
        historialButton.setBounds(200, 320,  100, 40);
    }
    private void addButtons(){
        add(jugarButton);
        add(historialButton);
    }
    public JButton getButton(){
        return jugarButton;
    }
}
