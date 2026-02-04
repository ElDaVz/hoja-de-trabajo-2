import app.Reader;
import app.Calculator;
import app.Calc;

/**
 * Clase principal del programa.
 * Se encarga de leer expresiones postfix desde un archivo,
 * evaluarlas utilizando la calculadora
 * y mostrar los resultados o errores correspondientes.
 */
public class Main {

    public static void main(String[] args) {

        Calc calculator = new Calculator();
        for (String expr : Reader.readFile("C:\\Users\\Danri\\Documents\\datos.txt")) {
            try {
                var result = calculator.operate(expr);
                System.out.println(expr + " = " + result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.printf("%s: %s%n", expr, e.getMessage());
            }
        }
    }
}