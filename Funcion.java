public class Funcion {
    private String fecha;
    private String hora;
    private int duracion;
    private String grupo;
    private Ubicacion ubicacion;

    public Funcion(String fecha, String hora, int duracion, String grupo, Ubicacion ubicacion) {
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.grupo = grupo;
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGrupo() {
        return grupo;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
