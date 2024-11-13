public class Ubicacion {
    private String tipo;
    private double precioBase;

    public Ubicacion(String tipo, int capacidad, double precioBase) {
        this.tipo = tipo;
        this.precioBase = precioBase;
    }

    public double calcularCostoUbicacion() {
        return precioBase;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}
