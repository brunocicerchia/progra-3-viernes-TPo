public class LogisticaRutas {

    final static int INF = 99999; // Representación de infinito para caminos no conectados.

    // Método para ejecutar el algoritmo de Floyd-Warshall
    public void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];

        // Inicializar distancias basadas en el grafo de entrada.
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Verificar si la inclusión de un nodo intermedio mejora la distancia
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Comprobar si hay ciclos negativos
        detectNegativeCycles(dist, V);

        // Imprimir la solución
        printSolution(dist, V);
    }

    // Método para detectar ciclos negativos en el grafo
    void detectNegativeCycles(int dist[][], int V) {
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Ciclo negativo detectado en el nodo " + i);
            }
        }
    }

    // Imprimir la matriz de distancias más cortas entre todos los nodos
    void printSolution(int dist[][], int V) {
        System.out.println("Tiempos mínimos de entrega entre centros de distribución:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Número de centros de distribución (nodos)
        int V = 4;

        // Grafo representando tiempos de viaje entre centros de distribución
        int graph[][] = {
            {0, 3, INF, 7},  // Nodo 1: Conexiones y tiempos con otros nodos
            {8, 0, 2, INF},  // Nodo 2
            {5, INF, 0, 1},  // Nodo 3
            {2, INF, INF, 0}  // Nodo 4
        };

        // Crear instancia de la clase LogisticaRutas
        LogisticaRutas lr = new LogisticaRutas();

        // Ejecutar el algoritmo de Floyd-Warshall
        lr.floydWarshall(graph, V);
    }
}
