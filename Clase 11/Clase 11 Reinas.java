public class reinas {
    private static final int tamaño = 4; // Tamaño del tablero 4x4

    public static void main(String[] args) {

        int[][] tablero = new int[tamaño][tamaño];

        // Comenzamos la búsqueda para colocar los elementos
        Reinas(tablero, 0, 0, 0);
    }

    private static void Reinas(int[][] tablero, int fila, int col, int elementosColocados) {
        if (elementosColocados == 2) {
            // Si ya colocamos los 2 elementos, imprimimos el tablero
            imprimirTablero(tablero);
            return;
        }

        // Recorremos cada celda del tablero a partir de la posición actual
        for (int i = fila; i < tamaño; i++) {
            for (int j = (i == fila ? col : 0); j < tamaño; j++) {
                if (colocar(tablero, i, j)) {
                    // Colocamos el elemento en la posición (i, j)
                    tablero[i][j] = 1;
                    // Intentamos colocar el siguiente elemento
                    Reinas(tablero, i, j + 1, elementosColocados + 1);
                    // Retiramos el elemento para volver atrás (backtracking)
                    tablero[i][j] = 0;
                }
            }
        }
    }

    private static boolean colocar(int[][] tablero, int fila, int col) {
        // Verificamos si hay otro elemento en la misma fila
        if (hayElementoEnFila(tablero, fila)) {
            return false;
        }

        // Verificamos si hay otro elemento en la misma columna
        if (hayElementoEnColumna(tablero, col)) {
            return false;
        }

        // Verificamos si hay otro elemento en las diagonales
        if (hayElementoEnDiagonales(tablero, fila, col)) {
            return false;
        }

        return true;  // Si no hay conflictos, es seguro colocar el elemento
    }

    private static boolean hayElementoEnFila(int[][] tablero, int fila) {
        // Recorremos todas las columnas en la fila para ver si ya hay un elemento
        for (int i = 0; i < tamaño; i++) {
            if (tablero[fila][i] == 1) {
                return true;  // Si hay un elemento en la fila, no es seguro
            }
        }
        return false;  // No hay elementos en la fila
    }

    private static boolean hayElementoEnColumna(int[][] tablero, int col) {
        // Recorremos todas las filas en la columna para ver si ya hay un elemento
        for (int i = 0; i < tamaño; i++) {
            if (tablero[i][col] == 1) {
                return true;  // Si hay un elemento en la columna, no es seguro
            }
        }
        return false;  // No hay elementos en la columna
    }

    private static boolean hayElementoEnDiagonales(int[][] tablero, int fila, int col) {
        // Comprobamos las diagonales (superior izquierda a inferior derecha)
        for (int i = -tamaño; i < tamaño; i++) {
            int diag1Fila = fila + i;
            int diag1Col = col + i;
            int diag2Fila = fila + i;
            int diag2Col = col - i;

            // Verificamos la primera diagonal (superior izquierda a inferior derecha)
            if (diag1Fila >= 0 && diag1Fila < tamaño && diag1Col >= 0 && diag1Col < tamaño) {
                if (tablero[diag1Fila][diag1Col] == 1) {
                    return true;  // Hay un elemento en esta diagonal
                }
            }

            // Verificamos la segunda diagonal (superior derecha a inferior izquierda)
            if (diag2Fila >= 0 && diag2Fila < tamaño && diag2Col >= 0 && diag2Col < tamaño) {
                if (tablero[diag2Fila][diag2Col] == 1) {
                    return true;  // Hay un elemento en esta diagonal
                }
            }
        }
        return false;  // No hay elementos en las diagonales
    }

    private static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                System.out.print(tablero[i][j] == 1 ? "E " : " -"); // 'E' representa el elemento colocado
            }
            System.out.println();
        }
        System.out.println();
    }
}
