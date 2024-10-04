public class Mochila {
    // Datos del problema
    static int[] pesos = {3, 4, 2};
    static int[] valores = {4, 5, 3};
    static int capacidad = 6;
    // Programación Dinámica: Usamos una tabla para almacenar los resultados de subproblemas
    public static int mochilaDinamica() {
        int n = pesos.length;
        int[][] dp = new int[n + 1][capacidad + 1];

        // Llenamos la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacidad; w++) {
                if (pesos[i - 1] <= w) {
                    // Caso de incluir el objeto i-1 o no incluirlo
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - pesos[i - 1]] + valores[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w]; // No se puede incluir el objeto
                }
            }
        }
        return dp[n][capacidad]; // El valor máximo que cabe en la mochila
    }
    public static void main(String[] args) {
        // Solución por Programación Dinámica
        int resultadoDinamico = mochilaDinamica();
        System.out.println("Valor máximo con Programación Dinámica: " + resultadoDinamico);
    }
}
