public class Actividad2 {

    // Implementación de búsqueda binaria
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Verificamos si el elemento está en el medio
            if (arr[mid] == target) {
                return mid;  // Elemento encontrado
            }

            // Si el target es mayor, ignoramos la mitad izquierda
            if (arr[mid] < target) {
                left = mid + 1;
            } 
            // Si el target es menor, ignoramos la mitad derecha
            else {
                right = mid - 1;
            }
        }

        // Si llegamos hasta aquí, el elemento no estaba en el array
        return -1;
    }

    public static void main(String[] args) {
        int[] arrayOrdenado = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int elementoABuscar = 7;

        int resultado = binarySearch(arrayOrdenado, elementoABuscar);

        if (resultado != -1) {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        } else {
            System.out.println("Elemento no encontrado en el array.");
        }
    }
}
