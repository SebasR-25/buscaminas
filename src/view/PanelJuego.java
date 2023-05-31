package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelJuego extends JPanel {
    private ActionListener actionListener;

    public PanelJuego(ActionListener actionListener) {
        this.actionListener = actionListener;
        setLayout(new GridLayout(20, 20));
        setVisible(true);
    }

    private void paintFont(JButton boton) {
        if (boton.getText().equals("0")||boton.getText().equals("1")) {
            boton.setForeground(Color.GREEN);
        } else if (boton.getText().equals("2")) {
            boton.setForeground(Color.BLUE);
        } else {
            boton.setForeground(Color.RED);
        }
    }

    public void loadGame(int celdas) {
        removeAll();
        setLayout(new GridLayout(celdas, celdas));
        loadButtons(celdas);
        setVisible(true);
    }

    private void loadButtons(int celdas) {
        for (int i = 0; i < celdas * celdas; i++) {
            JButton tempButton = new JButton();
            tempButton.setFont(new Font("Dialog", Font.BOLD, celdas == 20 ? 9 : celdas == 10 ? 20 : 15));
            tempButton.setName(i / (celdas) + " " + i % (celdas));
            tempButton.addActionListener(actionListener);
            tempButton.setActionCommand("BOTON_JUEGO");
            add(tempButton);
        }
    }

    public void unableAllButtons() {
        for (Component component : getComponents()) {
            component.setEnabled(false);
        }
    }

    public void setAllButtonsText(int[][] visitadas) {
        for (Component component : getComponents()) {
            JButton tempButton = (JButton) component;
            tempButton.setText(visitadas[Integer.parseInt(tempButton.getName().split(" ")[0])][Integer.parseInt(tempButton.getName().split(" ")[1])] + "");
            setColor(tempButton, Integer.parseInt(tempButton.getText()));
        }
    }

    public void setColor(JButton button, int i) {
        switch (i) {
            case 0, 1 -> button.setForeground(Color.GREEN);
            case 2 -> button.setForeground(Color.BLUE);
            default -> button.setForeground(Color.RED);
        }
    }
}
