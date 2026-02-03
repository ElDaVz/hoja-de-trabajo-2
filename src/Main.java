import app.Reader;
import app.PostFixCalculator;
import app.Calc;

public class Main {

    public static void main(String[] args) {

        Calc calculator = new PostFixCalculator();
        for (String expr : Reader.readFile("C:\\Users\\Danri\\Documents\\datos.txt")) {
            try {
                int result = calculator.operate(expr);
                System.out.println(expr + " = " + result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(String.format("%s: %s", expr, e.getMessage()));
            }
        }
    }
}