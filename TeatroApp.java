import java.util.ArrayList;
import java.util.Scanner;

public class TeatroApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Teatro teatro = new Teatro("Teatro Principal");
        ArrayList<Entrada> entradasCompradas = new ArrayList<>(); // Lista para almacenar las entradas compradas

        // Agregar ubicaciones específicas
        teatro.agregarUbicacion("Platea Baja", 100, 200.0);
        teatro.agregarUbicacion("Platea Alta", 150, 150.0);
        teatro.agregarUbicacion("Balcón", 200, 100.0);
        teatro.agregarUbicacion("Galería", 300, 50.0);

        // Agregar funciones
        teatro.agregarFuncion("2024-12-20", "20:00", 120, "Grupo A", teatro.getUbicaciones().get(0));
        teatro.agregarFuncion("2024-12-21", "18:00", 90, "Grupo B", teatro.getUbicaciones().get(1));
        teatro.agregarFuncion("2024-12-22", "21:00", 110, "Grupo C", teatro.getUbicaciones().get(2));

        // Mensaje de bienvenida e invitación
        System.out.println("========================================");
        System.out.println("¡Bienvenido al sistema de compra de entradas del Teatro Principal!");
        System.out.println("A continuación, completará un formulario para seleccionar la función y la ubicación deseadas.");
        System.out.println("========================================\n");

        // Mostrar listado de funciones disponibles
        teatro.mostrarFunciones();

        // Iniciar proceso de compra de entradas
        while (true) {
            System.out.println("\nSeleccione la función deseada:");
            teatro.mostrarFunciones();

            System.out.print("Ingrese el número de la función: ");
            int funcionIndex = scanner.nextInt() - 1;
            Funcion funcion = teatro.getFunciones().get(funcionIndex);

            // Mostrar ubicaciones y calcular precio automáticamente
            System.out.println("\nUbicaciones disponibles:");
            System.out.println("----------------------------------------");
            for (int i = 0; i < teatro.getUbicaciones().size(); i++) {
                Ubicacion ubicacion = teatro.getUbicaciones().get(i);
                System.out.printf("%d. %s - Precio por entrada: $%.2f%n",
                        i + 1, ubicacion.getTipo(), ubicacion.getPrecioBase());
            }
            System.out.println("----------------------------------------");

            System.out.print("Ingrese el número de la ubicación: ");
            int ubicacionIndex = scanner.nextInt() - 1;
            Ubicacion ubicacion = teatro.getUbicaciones().get(ubicacionIndex);

            // Crear la entrada usando el factory y agregarla a la lista de entradas compradas
            Entrada entrada = EntradaFactory.crearEntrada(funcion, ubicacion);
            entradasCompradas.add(entrada);

            System.out.println("\n========================================");
            System.out.printf("Entrada creada exitosamente para la función: %s%n", funcion.getFecha());
            System.out.printf("Hora: %s%n", funcion.getHora());
            System.out.printf("Grupo: %s%n", funcion.getGrupo());
            System.out.printf("Ubicación: %s%n", ubicacion.getTipo());
            System.out.printf("Precio: $%.2f%n", entrada.getPrecio());
            System.out.println("========================================\n");

            System.out.print("¿Desea comprar otra entrada? (s/n): ");
            String continuar = scanner.next();
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }

        // Mostrar el resumen de la operación al finalizar
        System.out.println("\n================= RESUMEN DE LA OPERACIÓN =================");
        double precioTotal = 0;
        for (int i = 0; i < entradasCompradas.size(); i++) {
            Entrada entrada = entradasCompradas.get(i);
            Funcion funcion = teatro.getFunciones().get(i); // Obtener la función asociada
            Ubicacion ubicacion = funcion.getUbicacion(); // Obtener la ubicación asociada

            System.out.printf("%d. Grupo: %s, Ubicación: %s, Hora: %s, Precio: $%.2f%n",
                    i + 1, funcion.getGrupo(), ubicacion.getTipo(), funcion.getHora(), entrada.getPrecio());
            precioTotal += entrada.getPrecio();
        }
        System.out.printf("Precio total de las entradas compradas: $%.2f%n", precioTotal);
        System.out.println("==========================================================\n");

        System.out.println("Gracias por utilizar el sistema de compra de entradas. ¡Disfrute su función!");
        scanner.close();
    }
}
