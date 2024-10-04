import java.util.Arrays;

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
        int[] monedas = {1, 5, 10, 25};
        int monto = 36;

        if (contadorCambio(monedas, monto)) {
            System.out.println("Es posible entregar el cambio exacto.");
        } else {
            System.out.println("No es posible entregar el cambio exacto.");
        }
    }
}
