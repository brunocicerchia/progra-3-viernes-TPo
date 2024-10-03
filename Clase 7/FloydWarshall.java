// Actividad 1 de la clase 7
public class FloydWarshall {

    final static int INF = 99999; // Definimos un valor para representar el infinito

    public static void main(String[] args) {
        int numNodos = 4;
        
        // Grafo con 4 nodos y sus aristas con pesos dados
        int graph[][] = {
            {0, 2, INF, 5},  // Nodo 1: 1 -> 2 (peso 2), 1 -> 4 (peso 5)
            {INF, 0, INF, 4}, // Nodo 2: 2 -> 4 (peso 4)
            {INF, INF, 0, INF}, // Nodo 3: No tiene aristas salientes
            {INF, INF, 2, 0}  // Nodo 4: 4 -> 3 (peso 2)
        };

        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.floydWarshall(graph, numNodos);
    }

    // Método que implementa el algoritmo de Floyd-Warshall
    void floydWarshall(int graph[][], int numNodos) {
        int dist[][] = new int[numNodos][numNodos];
        
        // Paso 1: Inicialización de la matriz de distancias con los valores iniciales del grafo
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                dist[i][j] = graph[i][j];
            }
        }
        
        // Paso 2: Aplicar la programación dinámica para encontrar los caminos más cortos
        for (int k = 0; k < numNodos; k++) {
            for (int i = 0; i < numNodos; i++) {
                for (int j = 0; j < numNodos; j++) {
                    // Si el nodo intermedio k mejora la distancia de i a j, actualizamos la distancia
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        // Imprimir la solución final
        printSolution(dist, numNodos);
    }

    // Método para imprimir la matriz de distancias más cortas
    void printSolution(int dist[][], int numNodos) {
        System.out.println("Matriz de distancias más cortas entre todos los pares de nodos:");
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
}
