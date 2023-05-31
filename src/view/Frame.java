package view;

import javax.swing.*;

public class Frame extends JFrame{
    private PanelInicio inicio;
    private PanelNombre panelNombre;
    private PanelJuego juego;

    public Frame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);
        setLocationRelativeTo(null);
        initPanels();
        jugarListener();
        add(juego);
        setVisible(true);
    }

    private void initPanels(){
        inicio = new PanelInicio();
        panelNombre = new PanelNombre();
        juego = new PanelJuego("1");
    }
    private void jugarListener(){
        inicio.getButton().addActionListener(e->{
            remove(inicio);
            add(panelNombre);
            revalidate();
            repaint();
        });
    }
}
