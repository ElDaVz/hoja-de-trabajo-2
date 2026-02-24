package app;
import java.util.Scanner;

public class StackFactory {

    public static <T> Stack<T> create(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Que implementacion de Stack desea usar?");
        System.out.println("1. Arraylist");
        System.out.println("2. Vector");
        System.out.println("3. Lista encadenada (simple o doble");
        System.out.println("1-3");

        int opcion = sc.nextInt();

        return switch (opcion){
            case 1 -> new StackA<>(10);
            case 2 -> new StackO<>(10);
            default -> throw new IllegalStateException("Unexpected value: " + opcion);
        };
    }
}
