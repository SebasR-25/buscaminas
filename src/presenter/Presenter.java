package presenter;

import model.*;
import view.*;

public class Presenter {
    private Frame frame;
    private BuscaMinas buscaMinas;

    public Presenter(){
        frame = new Frame();
//        buscaMinas = new BuscaMinas();
    }

    public static void main(String[] args) {
        new Presenter();
    }
}
