public class SistemaRegistro {

    public static void main(String[] args) {
        GestionLenguaje gestionLenguaje = new GestionLenguaje();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Agregar Lenguaje");
            System.out.println("2. Buscar Lenguaje");
            System.out.println("3. Eliminar Lenguaje");
            System.out.println("4. Imprimir Lenguajes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Año de creación: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Característica principal: ");
                    String caracteristica = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Utilización: ");
                    String utilizacion = scanner.nextLine();
                    gestionLenguaje.agregarLenguaje(anio, caracteristica, nombre, utilizacion);
                    System.out.println("¡Lenguaje agregado!");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del lenguaje a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    LenguajeProgramacion encontrado = gestionLenguaje.buscarLenguaje(nombreBuscar);
                    if (encontrado != null) {
                        System.out.println("Lenguaje encontrado: " + encontrado);
                    } else {
                        System.out.println("Lenguaje no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del lenguaje a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    if (gestionLenguaje.eliminarLenguaje(nombreEliminar)) {
                        System.out.println("Lenguaje eliminado.");
                    } else {
                        System.out.println("Lenguaje no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Lista de lenguajes:");
                    gestionLenguaje.imprimirLenguajes();
                    break;

                case 5:
                    System.out.println("¡Saliendo del sistema!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);

       
    }
}
