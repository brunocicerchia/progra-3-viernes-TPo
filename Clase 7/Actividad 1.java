public class Actividad1 {

    final static int INF = 99999; 

    
    public void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];

        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        
        printSolution(dist, V);
    }

    
    void printSolution(int dist[][], int V) {
        System.out.println("Distancias más cortas entre cada par de nodos:");
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
        
        int V = 4;

        
        int graph[][] = {
            {0, 2, INF, 5},  
            {INF, 0, INF, 4}, 
            {INF, INF, 0, INF},
            {INF, INF, 2, 0}   
        };

        
        Actividad1 a = new Actividad1();

        
        a.floydWarshall(graph, V);
    }
}
