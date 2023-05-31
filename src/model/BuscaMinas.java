package model;

public class BuscaMinas{
    private Celda[][] tablero;
    private int[][] visitadas;
    private int celdas;
    private static final int[] ROW_OFFSETS = {-1, 1, 0, 0};
    private static final int[] COL_OFFSETS = {0, 0, -1, 1};

    public BuscaMinas(int celdas){
        tablero = new Celda[celdas][celdas];
        visitadas = new int[celdas][celdas];
        this.celdas = celdas;
        llenarTablero();
        ubicarMinas();
        contarAdyacentes(celdas, celdas);
    }

    private void ubicarMinas(){
        for (int i = 0; i < 30; i++) {
            int x = (int)(Math.random()*10);
            int y = (int)(Math.random()*10);
            if (!validarMina(x, y)) {
                tablero[x][y].setEsMina(true);
            }
        }
    }
    private void llenarTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = new Celda(false);
            }
        }
    }
    private boolean validarMina(int x, int y){
        boolean result = false;
        if (tablero[x][y].getEsMina()) {
            result = true;
        }
        return result;
    }
    private int contarAdyacentes(int row, int col) {
        int count = 0;
        visitadas[row-1][col-1] = 1;
        for (int k = 0; k < 4; k++) {
            int newRow = row + ROW_OFFSETS[k];
            int newCol = col + COL_OFFSETS[k];
            if (esValida(newRow, newCol) && tablero[newRow][newCol].getEsMina() == false) {
                count++;
                tablero[newCol][newRow].setMinasAdyacentes(count);
                count += contarAdyacentes(newCol, newRow);
            }
        }
        return count;
    }
    private boolean esValida(int row, int col) {
        int rows = tablero.length;
        int cols = tablero[0].length;
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (visitadas[row][col] != 1) {
                return true;
            }
        }
        return false;
    }
    private String myToString(){
        String result = "";
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if(validarMina(i, j)){
                    result += "m,";
                }else{
                    result+="v,";
                }
            }
            result+= "\n";
        }
        return result;
    }
    public String myToStringNumber(){
        String result = "";
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                result += tablero[i][j].getMinasAdyacentes()+",";
            }
            result += "\n";
        }
        return result;
    }
    public void setCeldas(int celdas){
        this.celdas = celdas;
    }
    public int getCeldas(){
        return celdas;
    }

    public static void main(String[] args) {
        BuscaMinas b = new BuscaMinas(10);
        System.out.println(b.myToString());
        System.out.println(b.myToStringNumber());
        System.out.println(b.tablero[0][0].getMinasAdyacentes() + "esta es la primera celda");
    }
    /*
     * en el panel donde se ingresa el nombre se agrega una forma de elegir dificultad, las dificultades se deben sacar cada una de un archivo de texto que contienen el tamaño de la matriz(10, 15, 20) y la cantidad de minas(30%, 35%, 40%)
     * 
     * hacer destapada en cadena, se destapan los caminos que tengan menos minas o que no tengan
     * 
     * si hay 1 mina verde, si hay 2 azul y si hay mas de 2 rojo
     */
}