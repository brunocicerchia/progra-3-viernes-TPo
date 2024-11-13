public class EntradaFactory {
    public static Entrada crearEntrada(Funcion funcion, Ubicacion ubicacion) {
        double precio = ubicacion.calcularCostoUbicacion();
        return new Entrada(precio);
    }
}
