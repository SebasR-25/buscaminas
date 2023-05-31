package view;

import javax.swing.*;
import java.awt.*;

public class PanelJuego extends JPanel{
    public PanelJuego(String text){
        setLayout(new GridLayout(20, 20));
        loadButtons(text);
        setVisible(true);
    }

    private void loadButtons(String text){
        for (int i = 0; i < 400; i++) {
            JButton tempButton = new JButton();
            setActionListener(tempButton, text);
            add(tempButton);
        }
    }
    private void setActionListener(JButton boton, String text){
        boton.addActionListener(e->{
            boton.setText(text);
            paintFont(boton, text);
        });
    }
    private void paintFont(JButton boton, String text){
        if (text.equals("1")) {
            boton.setForeground(Color.green);
        }else if(text.equals("2")){
            boton.setForeground(Color.blue);
        }else{
            boton.setForeground(Color.red);
        }
    }
}
