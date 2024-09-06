public class SumaRecursiva {

    public static int suma(int n) {
        
        if (n == 0) {
            return 0;
        }
        
        return n + suma(n - 1);
    }

    public static void main(String[] args) {
        int n = 20; 
        System.out.println("La suma de los primeros " + n + " números es: " + suma(n));
    }
}


