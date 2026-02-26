package app;
import java.util.Scanner;

public class StackFactory {

    private static final Scanner sc = new Scanner(System.in);

    public static int askOption() {
        System.out.println("\n¿Qué implementación de Stack desea usar?");
        System.out.println("  1. ArrayList");
        System.out.println("  2. Arreglo dinámico (Vector)");
        System.out.println("  3. Lista encadenada");
        System.out.print("Ingrese una opción (1-3): ");
        return sc.nextInt();
    }

    public static int askListOption() {
        System.out.println("\n¿Qué implementación de Lista desea usar?");
        System.out.println("  1. Simplemente encadenada");
        System.out.println("  2. Doblemente encadenada");
        System.out.print("Ingrese una opción (1-2): ");
        return sc.nextInt();
    }


    public static <T> Stack<T> create(int opcion, int listOpcion){
        return switch (opcion) {
            case 1 -> new StackA<>(10);
            case 2 -> new StackO<>(10);
            case 3 -> new StackL<>(createList(listOpcion));
            default -> throw new IllegalArgumentException("Opción inválida: " + opcion);
        };



    }

    /**
     * Solicita al usuario el tipo de lista encadenada a utilizar.
     *
     * @param <T> Tipo de los elementos de la lista.
     * @return Una implementación concreta de List.
     */
    public static <T> List<T> createList(int opcion) {
        return switch (opcion) {
            case 1 -> new SingleLinkedList<>();
            case 2 -> new DoubleLinkedList<>();
            default -> throw new IllegalArgumentException("Opción inválida: " + opcion);
        };
    }
}
