import java.util.ArrayList;
import java.util.List;


//Actividad 1 Aplicar la técnica de Divide y Vencerás en una lista de clientes con id, nombre y scoring, buscando el cliente con el scoring máximo
 class Cliente {

    private int id;
    private String nombre;
    private double scoring;


    public Cliente(int id,String nombre,double scoring){
        this.id=id;
        this.nombre=nombre;
        this.scoring=scoring;

    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getScoring() {
        return scoring;
    }
    
}

public class actividad1 {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente(1, "Diego", 750));
        clientes.add(new Cliente(2, "Lionel", 680));
        clientes.add(new Cliente(3, "Carlos", 720));
        clientes.add(new Cliente(4, "Rogelio", 400));
        clientes.add(new Cliente(5, "Sebastian", 320));
        clientes.add(new Cliente(6, "Juan", 600));

        System.out.println("El scoring mas alto es : "+mayor(clientes));


       
    }

    private static double mayor(List<Cliente> clientes) {
        return mayor(clientes,0,clientes.size());
    }

    private static double mayor(List<Cliente> clientes, int i, int f){
        if (i == f - 1) {
            return clientes.get(i).getScoring();
        }
        int mitad = (i + f) / 2;
        double izq = mayor(clientes, i, mitad);
        double der = mayor(clientes, mitad, f);
        if(izq>der){
            return izq;
        }
        else{
            return der;
        }
    }

}
