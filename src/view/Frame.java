package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Frame extends JFrame{
    private PanelInicio inicio;
    private PanelNombre panelNombre;
    private PanelJuego juego;

    public Frame(ActionListener actionListener) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 500);
        setLocationRelativeTo(null);
        initPanels(actionListener);
        jugarListener();
        add(inicio);
        setVisible(true);
    }

    private void initPanels(ActionListener actionListener){
        inicio = new PanelInicio();
        panelNombre = new PanelNombre(actionListener);
        juego = new PanelJuego(actionListener);
    }
    private void jugarListener(){
        inicio.getButton().addActionListener(e->{
            remove(inicio);
            add(panelNombre);
            revalidate();
            repaint();
        });
    }

    public PanelInicio getInicio() {
        return inicio;
    }

    public void setInicio(PanelInicio inicio) {
        this.inicio = inicio;
    }

    public PanelNombre getPanelNombre() {
        return panelNombre;
    }

    public void setPanelNombre(PanelNombre panelNombre) {
        this.panelNombre = panelNombre;
    }

    public PanelJuego getJuego() {
        return juego;
    }

    public void setJuego(PanelJuego juego) {
        this.juego = juego;
    }

    public void changePanel(JPanel panel) {
        remove(getContentPane());
        setContentPane(panel);
        revalidate();
        repaint();
    }

    public void showDialog(String perdiste) {
        JOptionPane.showMessageDialog(this, perdiste);
    }

    public void unableAllButtons() {
        juego.unableAllButtons();
    }

    public void setAllButtonsText(int[][] visitadas) {
        juego.setAllButtonsText(visitadas);
    }

    public void setColor(JButton button, int i) {
        juego.setColor(button, i);
    }
}
