public class EjemploLongBigInteger {
    public static void main(String[] args) {
        // Uso del tipo primitivo long
        long numeroLong = 9223372036854775807L; // Valor máximo de long
        System.out.println("Valor de long: " + numeroLong);

        // Operación simple con long
        long resultadoLong = numeroLong - 100;
        System.out.println("Resultado con long: " + resultadoLong);

        // Uso de BigInteger
        BigInteger numeroBigInteger = new BigInteger("9223372036854775807000000"); // Número muy grande
        System.out.println("Valor de BigInteger: " + numeroBigInteger);

        // Operaciones con BigInteger
        BigInteger suma = numeroBigInteger.add(new BigInteger("100000000000000000000"));
        BigInteger multiplicacion = numeroBigInteger.multiply(new BigInteger("2"));
        BigInteger potencia = numeroBigInteger.pow(2);

        System.out.println("Suma con BigInteger: " + suma);
        System.out.println("Multiplicación con BigInteger: " + multiplicacion);
        System.out.println("Potencia con BigInteger: " + potencia);
    }
}