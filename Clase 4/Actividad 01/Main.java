import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static boolean contadorCambio(int[] monedas, int monto) {
        Arrays.sort(monedas); 
        for (int i = monedas.length - 1; i >= 0; i--) {
            while (monto >= monedas[i]) {
                monto -= monedas[i]; 
            }
        }
        return monto == 0; 
    }

    public static void main(String[] args) {

        // Crear un Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);
        try {
            // Preguntar al usuario por el monto
            System.out.print("Ingrese el monto para el cambio: ");
            int monto = sc.nextInt();  // Leer el monto ingresado por el usuario

            int[] monedas = {2, 5, 10, 25};

            if (contadorCambio(monedas, monto)) {
                System.out.println("Es posible entregar el cambio exacto.");
            } else {
                System.out.println("No es posible entregar el cambio exacto.");
            }
        } finally {
            sc.close();
        }
    }
}
