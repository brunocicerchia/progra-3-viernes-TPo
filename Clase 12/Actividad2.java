package explorador;

import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;

public class Actividad2 {

    // Método para agregar un nodo al grafo
    public static void agregarNodo(int nodo, Map<Integer, ArrayList<Integer>> grafo) {
        grafo.put(nodo, new ArrayList<>());
    }

    // Método para conectar dos nodos
    public static void conectarNodos(int origen, int destino, Map<Integer, ArrayList<Integer>> grafo) {
        if (grafo.containsKey(origen)) {
            grafo.get(origen).add(destino);
        } else {
            System.out.println("El nodo " + origen + " no existe.");
        }
    }

    // Método para realizar BFS (Breadth-First Search)
    public static void recorrerBFS(int inicio, Map<Integer, ArrayList<Integer>> grafo) {
        boolean[] visitados = new boolean[grafo.size()]; // Seguimiento de nodos visitados
        LinkedList<Integer> cola = new LinkedList<>(); // Cola para el recorrido

        visitados[inicio] = true; // Marcar nodo inicial como visitado
        cola.add(inicio); // Añadir nodo inicial a la cola

        System.out.println("Iniciando recorrido BFS desde el nodo " + inicio + ":");
        while (!cola.isEmpty()) {
            int actual = cola.poll(); // Extraer el primer nodo de la cola
            System.out.print(actual + " -> "); // Procesar el nodo

            // Explorar los vecinos del nodo actual
            for (int vecino : grafo.get(actual)) {
                if (!visitados[vecino]) {
                    visitados[vecino] = true; // Marcar como visitado
                    cola.add(vecino); // Añadir a la cola
                }
            }
        }
        System.out.println(" Fin del recorrido.");
    }

    public static void main(String[] args) {
        // Crear el grafo
        Map<Integer, ArrayList<Integer>> grafo = new HashMap<>();

        // Agregar nodos
        for (int i = 0; i < 6; i++) {
            agregarNodo(i, grafo);
        }

        // Conectar nodos
        conectarNodos(0, 1, grafo);
        conectarNodos(0, 2, grafo);
        conectarNodos(1, 3, grafo);
        conectarNodos(1, 4, grafo);
        conectarNodos(2, 4, grafo);
        conectarNodos(3, 5, grafo);

        // Ejecutar BFS
        recorrerBFS(0, grafo);
    }
}
