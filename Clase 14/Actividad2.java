public class Actividad2 {

    // Tamaño del tablero
    private static final int SIZE = 6;

    public static void main(String[] args) {
        // Tablero inicial (0 representa una celda vacía)
        int[][] board = {
                {5, 3, 0, 0, 6, 0},
                {6, 0, 0, 5, 0, 3},
                {0, 0, 5, 0, 3, 0},
                {0, 6, 0, 3, 0, 0},
                {3, 0, 6, 0, 0, 5},
                {0, 5, 0, 0, 6, 0}
        };

        // Resolver el Sudoku
        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No existe solución para este Sudoku.");
        }
    }

    // Método que resuelve el Sudoku usando backtracking
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {  // Encuentra una celda vacía
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recursivamente intenta resolver el tablero
                            if (solveSudoku(board)) {
                                return true;
                            }

                            // Deshacer el intento si falla
                            board[row][col] = 0;
                        }
                    }
                    return false;  // Si ningún número es válido, retrocede
                }
            }
        }
        return true;  // El tablero está completo y es válido
    }

    // Método para verificar si un número puede ser colocado en una posición
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Verificar si el número está en la fila
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Verificar si el número está en la columna
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Verificar si el número está en el subcuadrante 2x3
        int startRow = row - row % 2; // Inicio de fila del subcuadrante
        int startCol = col - col % 3; // Inicio de columna del subcuadrante
        for (int i = 0; i < 2; i++) { // Subcuadrante de 2 filas
            for (int j = 0; j < 3; j++) { // Subcuadrante de 3 columnas
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;  // Si pasa todas las pruebas, es válido
    }

    // Método para imprimir el tablero
    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
