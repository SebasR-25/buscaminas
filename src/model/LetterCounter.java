package model;

public class LetterCounter {
    private static final int[] ROW_OFFSETS = {-1, 1, 0, 0};
    private static final int[] COL_OFFSETS = {0, 0, -1, 1};

    public static void main(String[] args) {
        char[][] matrix = {
            {'v', 'v', 'v', 'm', 'm', 'v', 'm', 'm', 'v', 'v'},
            {'m', 'v', 'm', 'v', 'v', 'v', 'v', 'm', 'm', 'v'},
            {'v', 'v', 'v', 'm', 'm', 'v', 'm', 'v', 'v', 'v'},
            {'v', 'v', 'v', 'v', 'v', 'm', 'm', 'v', 'v', 'v'},
            {'v', 'v', 'v', 'm', 'm', 'v', 'v', 'v', 'v', 'v'},
            {'m', 'm', 'v', 'v', 'm', 'v', 'v', 'v', 'v', 'v'},
            {'v', 'v', 'm', 'v', 'v', 'm', 'v', 'v', 'v', 'v'},
            {'m', 'v', 'm', 'v', 'v', 'v', 'v', 'v', 'm', 'v'},
            {'m', 'm', 'v', 'v', 'v', 'v', 'v', 'm', 'v', 'v'},
            {'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v', 'v'}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 'v' && visited[i][j] == 0) {
                    int count = countAdjacentMs(matrix, visited, i, j);
                    System.out.println("Cantidad de 'm' adyacentes a ('v', " + i + ", " + j + "): " + count);
                }
            }
        }
    }

    private static int countAdjacentMs(char[][] matrix, int[][] visited, int row, int col) {
        int count = 0;
        visited[row][col] = 1;

        for (int k = 0; k < 4; k++) {
            int newRow = row + ROW_OFFSETS[k];
            int newCol = col + COL_OFFSETS[k];

            if (isValidCell(matrix, visited, newRow, newCol) && matrix[newRow][newCol] == 'm') {
                count++;
                count += countAdjacentMs(matrix, visited, newRow, newCol);
            }
        }

        return count;
    }
    private static boolean isValidCell(char[][] matrix, int[][] visited, int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length;
    
        // Verificar si la celda está dentro de los límites de la matriz
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            // Verificar si la celda no ha sido visitada previamente
            if (visited[row][col] == 0) {
                return true;
            }
        }
    
        return false;
    }
}

