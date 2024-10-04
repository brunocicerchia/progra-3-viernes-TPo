import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Integer, Integer> calcularComprobantesMinimos(int[] comprobantes, int monto) {
        Arrays.sort(comprobantes); // Ordenar los comprobantes de menor a mayor
        Map<Integer, Integer> cantidadComprobantes = new HashMap<>(); // Almacenar la cantidad de cada comprobante

        for (int i = comprobantes.length - 1; i >= 0; i--) {
            int conteo = 0;
            while (monto >= comprobantes[i]) {
                monto -= comprobantes[i];
                conteo++; 
            }
            if (conteo > 0) {
                cantidadComprobantes.put(comprobantes[i], conteo); // Guardar la cantidad de ese comprobante
            }
        }
        return cantidadComprobantes; // Retornar el Map con las cantidades de cada comprobante
    }

    public static void main(String[] args) {
        // Definir monto
        int monto = 2420; 
        
        // Definir los comprobantes disponibles
        // 1000: Moneda fiat
        // 500: Cheque
        // 100: Bonos
        // 50: Tarjeta de crédito
        // 20: Transferencia bancaria
        // 10: Efectivo

        int[] comprobantes = {1000, 500, 100, 50, 20, 10};
        
        // Calcular la cantidad mínima de comprobantes
        Map<Integer, Integer> resultado = calcularComprobantesMinimos(comprobantes, monto);

        // Imprimir el resultado
        System.out.println("Para el monto de " + monto + ", se necesitan los siguientes comprobantes:");
        for (Map.Entry<Integer, Integer> entry : resultado.entrySet()) {
            System.out.println("Comprobante de " + entry.getKey() + ": " + entry.getValue() + " veces");
        }
    }
}