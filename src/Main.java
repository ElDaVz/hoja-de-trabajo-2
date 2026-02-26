import app.*;

import java.util.List;

/**
 * Clase principal del programa.
 * Usa Factory para elegir UNA vez la implementación de Stack,
 * y Singleton para obtener la única instancia de Calculator.
 */
public class Main {

    public static void main(String[] args) {

        int stackOpcion = 0 ;
        int listOpcion = 0;

        while (stackOpcion == 0) {
            try {
                stackOpcion = StackFactory.askOption();
                if (stackOpcion == 3) {
                    listOpcion = StackFactory.askListOption();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Intente de nuevo.");
                stackOpcion = 0;
            }
        }
        Stack<Character> converterStack  = StackFactory.create(stackOpcion, listOpcion);

        Calculator calc = Calculator.getInstance(stackOpcion, listOpcion);

        InfixConverter converter = new InfixConverter(converterStack);
        List<String> lines = Reader.readFile("datos.txt");

        for (String line : lines) {
            try {
                String postfix   = converter.convert(line);
                double resultado = calc.operate(postfix);

                System.out.println("Infix:     " + line);
                System.out.println("Postfix:   " + postfix);
                System.out.println("Resultado: " + resultado);
            } catch (Exception e) {
                System.out.println("Error en expresión '" + line + "': " + e.getMessage());
            }
        }
    }
}
