package grafos;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Actividad1 {

    // Método para agregar un nodo al grafo
    public static void anadirNodo(int nodo, Map<Integer, ArrayList<Integer>> grafo) {
        grafo.put(nodo, new ArrayList<>());
    }

    // Método para agregar una conexión entre nodos
    public static void anadirConexion(int origen, int destino, Map<Integer, ArrayList<Integer>> grafo) {
        if (grafo.containsKey(origen)) {
            grafo.get(origen).add(destino);
        } else {
            System.out.println("El nodo " + origen + " no existe en el grafo.");
        }
    }

    // Método recursivo para realizar DFS
    private static void recorrerDFS(int nodo, boolean[] visitados, Map<Integer, ArrayList<Integer>> grafo) {
        visitados[nodo] = true;
        System.out.print(nodo + " -> ");

        // Recorrer los nodos adyacentes
        for (int vecino : grafo.get(nodo)) {
            if (!visitados[vecino]) {
                recorrerDFS(vecino, visitados, grafo);
            }
        }
    }

    // Método principal de DFS que inicializa los valores necesarios
    public static void explorarDFS(int inicio, Map<Integer, ArrayList<Integer>> grafo) {
        boolean[] visitados = new boolean[grafo.size()];
        System.out.println("Iniciando DFS desde el nodo " + inicio + ":");
        recorrerDFS(inicio, visitados, grafo);
        System.out.println(" Fin del recorrido.");
    }

    public static void main(String[] args) {
        Map<Integer, ArrayList<Integer>> grafo = new HashMap<>();

        // Agregar nodos al grafo
        for (int i = 0; i < 7; i++) {
            anadirNodo(i, grafo);
        }

        // Agregar conexiones entre nodos
        anadirConexion(0, 1, grafo);
        anadirConexion(0, 2, grafo);
        anadirConexion(0, 4, grafo);
        anadirConexion(1, 3, grafo);
        anadirConexion(1, 5, grafo);
        anadirConexion(2, 6, grafo);
        anadirConexion(4, 5, grafo);

        // Imprimir las conexiones del nodo 0
        System.out.println("Conexiones del nodo 0: " + grafo.get(0));

        // Realizar el recorrido DFS desde el nodo 0
        explorarDFS(0, grafo);
    }
}
