
/*actividad 2 Actividad 2
Implementación de un Grafo en una Matriz de Adyacencia
Objetivo: Implementar un grafo utilizando una matriz de adyacencia en Java y
realizar varias operaciones para manipular y consultar el grafo.
Descripción del Problema:
Dado un grafo dirigido, tu tarea es implementar las siguientes operaciones
utilizando una matriz de adyacencia:
Operaciones: Inicialización del Grafo, Agregar Arista, Eliminar Arista, Verificar
Arista, Listar Adyacentes, Contar Grado de Entrada y Salida: Implementa métodos
para contar el grado de salida (número de aristas que salen) y el grado de entrada
(número de aristas que entran) de un vértice dado.
*/

class Grafo {
    private int[][] matrizAdyacencia;
    private int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 1; 
        } else {
            System.out.println("vertice no valido");
        }
    }

    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 0; 
        } else {
            System.out.println("vertice no valido");
        }
    }

    public boolean verificarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            return matrizAdyacencia[origen][destino] == 1;
        } else {
            System.out.println("vertice no valido");
            return false;
        }
    }

    public void listarAdyacentes(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            System.out.print("Vértices adyacentes a " + vertice + ": ");
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdyacencia[vertice][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println("vertice no valido");
        }
    }

    public int contarGradoSalida(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            int gradoSalida = 0;
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdyacencia[vertice][j] == 1) {
                    gradoSalida++;
                }
            }
            return gradoSalida;
        } else {
            System.out.println("vertice no valido");
            return -1;
        }
    }

    public int contarGradoEntrada(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            int gradoEntrada = 0;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[i][vertice] == 1) {
                    gradoEntrada++;
                }
            }
            return gradoEntrada;
        } else {
            System.out.println("vertice no valido");
            return -1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5); 

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 4);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 4);
        grafo.agregarArista(3, 0);
        grafo.agregarArista(4, 3);

        System.out.println( grafo.verificarArista(0, 1));
        System.out.println( grafo.verificarArista(1, 0));

        grafo.listarAdyacentes(1);

        System.out.println( grafo.contarGradoSalida(1));
        System.out.println(grafo.contarGradoEntrada(1));

        grafo.eliminarArista(1, 2);
        System.out.println(grafo.verificarArista(1, 2));
    }
}
