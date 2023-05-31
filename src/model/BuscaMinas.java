package model;

import java.util.Arrays;

public class BuscaMinas {
    private Celda[][] tablero;
    private int[][] visitadas;
    private int celdas;
    private static final int[] ROW_OFFSETS = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] COL_OFFSETS = {0, 0, -1, 1, -1, 1, -1, 1};

    public BuscaMinas() {
    }

    private void ubicarMinas(double porcentaje) {
        int minas = (int) (porcentaje * celdas * celdas);
        for (int i = 0; i < minas; i++) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            if (!validarMina(x, y)) {
                tablero[x][y].setEsMina(true);
                tablero[x][y].setLetra("m");
            }
        }
    }

    private void llenarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = new Celda(false);
                tablero[i][j].setLetra("v");
            }
        }
    }

    private boolean validarMina(int x, int y) {
        boolean result = false;
        if (tablero[x][y].getEsMina()) {
            result = true;
        }
        return result;
    }

    private void setAdyacentes(Celda[][] matrix, int[][] visited) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (matrix[i][j].getLetra().equals("v") && visited[i][j] == 0) {
                    int count = contarAdyacentes(matrix, visited, i, j);
                    matrix[i][j].setMinasAdyacentes(count);
                }
            }
        }
    }

    private int contarAdyacentes(Celda[][] matrix, int[][] visited, int row, int col) {
        visited[row][col] = 1;
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int newRow = row + ROW_OFFSETS[k];
            int newCol = col + COL_OFFSETS[k];
            if (esValida(matrix, visited, newRow, newCol) && matrix[newRow][newCol].getEsMina() == true) {
                count++;
            }
        }
        return count;
    }

    private boolean esValida(Celda[][] matrix, int[][] visited, int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (visited[row][col] == 0) {
                return true;
            }
        }
        return false;
    }

    private String myToString() {
        String result = "";
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (validarMina(i, j)) {
                    result += "m,";
                } else {
                    result += "v,";
                }
            }
            result += "\n";
        }
        return result;
    }

    public void myStringVisitadas() {

    }

    public String myToStringNumber() {
        String result = "";
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                result += tablero[i][j].getMinasAdyacentes() + ",";
            }
            result += "\n";
        }
        return result;
    }

    private void fillVisitadas() {
        for (int i = 0; i < visitadas.length; i++) {
            for (int j = 0; j < visitadas.length; j++) {
                visitadas[i][j] = tablero[i][j].getMinasAdyacentes();
            }
        }
    }

    public void setCeldas(int celdas) {
        this.celdas = celdas;
    }

    public int getCeldas() {
        return celdas;
    }

    public static void main(String[] args) {
        BuscaMinas b = new BuscaMinas();
        System.out.println(b.myToString());
        System.out.println(b.myToStringNumber());
        System.out.println(b.tablero[0][0].getMinasAdyacentes() + "esta es la primera celda");
    }

    public void startGame(int columnas, double porcentaje) {
        System.out.println("entro al start game: " + columnas + " " + porcentaje);
        tablero = new Celda[columnas][columnas];
        visitadas = new int[columnas][columnas];
        celdas = columnas;
        llenarTablero();
        ubicarMinas(porcentaje);
        setAdyacentes(tablero, visitadas);
        fillVisitadas();
        System.out.println(myToString());
        System.out.println(myToStringNumber());
    }

    public Celda[][] getTablero() {
        return tablero;
    }

    public void setTablero(Celda[][] tablero) {
        this.tablero = tablero;
    }

    public int[][] getVisitadas() {
        return visitadas;
    }

    public void setVisitadas(int[][] visitadas) {
        this.visitadas = visitadas;
    }

    /*
     * en el panel donde se ingresa el nombre se agrega una forma de elegir dificultad, las dificultades se deben sacar cada una de un archivo de texto que contienen el tamaño de la matriz(10, 15, 20) y la cantidad de minas(30%, 35%, 40%)
     *
     * hacer destapada en cadena, se destapan los caminos que tengan menos minas o que no tengan
     *
     * si hay 1 mina verde, si hay 2 azul y si hay mas de 2 rojo
     */
}