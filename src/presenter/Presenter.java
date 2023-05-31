package presenter;

import FileOperation.Reader;
import model.*;
import view.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {
    private Frame frame;
    private BuscaMinas buscaMinas;
    private Reader reader;

    public Presenter() {
        frame = new Frame(this);
        buscaMinas = new BuscaMinas();
        reader = new Reader();
    }

    public static void main(String[] args) {
        new Presenter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "CONTINUAR":
                String nombre = frame.getPanelNombre().getNombreField().getText();
                String dificultad = frame.getPanelNombre().getDificultades().getSelectedItem().toString();
                System.out.println(nombre + " " + dificultad);
                String content = reader.readFile("src/resources/" + dificultad + ".txt");
                System.out.println(content);
                String[] lines = content.split(";");
                buscaMinas.startGame(Integer.parseInt(lines[0]), Double.parseDouble(lines[1]));
                frame.setSize(800, 700);
                frame.setLocationRelativeTo(null);
                frame.changePanel(frame.getJuego());
                frame.getJuego().loadGame(buscaMinas.getCeldas());
//                buscaMinas.setMinas(Integer.parseInt(lines[1]));
//                switch (dificultad) {
//                    case "FACIL":
//                        Reader reader = new Reader();
//                        String content = reader.readFile("src\\resources\\facil.txt");
//                        buscaMinas.setDificultad(Dificultad.FACIL);
//                        break;
//                    case "MEDIO":
//                        buscaMinas.setDificultad(Dificultad.MEDIO);
//                        break;
//                    case "DIFICIL":
//                        buscaMinas.setDificultad(Dificultad.DIFICIL);
//                        break;
//                }
                break;
            case "BOTON_JUEGO":
                JButton button = (JButton) e.getSource();
                int x = button.getName().charAt(0) - '0';
                int y = button.getName().charAt(2) - '0';
                button.setText(String.valueOf(buscaMinas.getVisitadas()[x][y]));
                //hacer lo mismo
                checkBomb(button, x, y);
                break;
        }
    }

    private void checkBomb(JButton button, int x, int y) {
        frame.setColor(button, buscaMinas.getVisitadas()[x][y]);
        if (buscaMinas.getTablero()[x][y].getEsMina()) {
            frame.showDialog("Perdiste");
            frame.setAllButtonsText(buscaMinas.getVisitadas());
//            frame.unableAllButtons();
        } else {

//            buscaMinas.getTablero()[x][y].setRevelado(true);
//            frame.getJuego().getButton(x, y).setText(String.valueOf(buscaMinas.getTablero()[x][y].getMinasAlrededor()));
//            frame.getJuego().getButton(x, y).setForeground(Color.green);
        }
    }
}
