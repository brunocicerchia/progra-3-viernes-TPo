import java.util.ArrayList;

public class Teatro {
    private String nombre;
    private ArrayList<Ubicacion> ubicaciones;
    private ArrayList<Funcion> funciones;

    public Teatro(String nombre) {
        this.nombre = nombre;
        this.ubicaciones = new ArrayList<>();
        this.funciones = new ArrayList<>();
    }

    public void agregarUbicacion(String tipo, int capacidad, double precioBase) {
        Ubicacion ubicacion = new Ubicacion(tipo, capacidad, precioBase);
        ubicaciones.add(ubicacion);
    }

    public void agregarFuncion(String fecha, String hora, int duracion, String grupo, Ubicacion ubicacion) {
        Funcion funcion = new Funcion(fecha, hora, duracion, grupo, ubicacion);
        funciones.add(funcion);
    }

    public void mostrarFunciones() {
        System.out.println("Funciones disponibles:");
        for (int i = 0; i < funciones.size(); i++) {
            Funcion funcion = funciones.get(i);
            System.out.printf("%d. Fecha: %s, Hora: %s, Duración: %d min, Grupo: %s%n",
                    i + 1, funcion.getFecha(), funcion.getHora(), funcion.getDuracion(), funcion.getGrupo());
        }
    }

    public ArrayList<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public ArrayList<Funcion> getFunciones() {
        return funciones;
    }
}
