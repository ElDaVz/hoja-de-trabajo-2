package app;
/**
 * @author Daniel Vásquez
 * Representa los operadores aritméticos soportados por la calculadora postfix.
 * Cada operador encapsula su propio comportamiento,
 * evitando el uso de estructuras condicionales.
 */
public enum Operator {

    SUMA('+') {
        @Override
        public int operate(int a, int b) {
            return a + b;
        }

    },
    RESTA('-') {
        @Override
        public int operate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLICACION('*') {
        @Override
        public int operate(int a, int b) {
            return a * b;
        }
    },
    DIVISION('/') {
        @Override
        public int operate(int a, int b) {
            try {
                return a / b;
            } catch (ArithmeticException e) {
                throw new ArithmeticException("Division by zero");
            }
        }
    };

    protected final char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Retorna el operador correspondiente a un símbolo.
     *
     * @param symbol símbolo a evaluar.
     * @return operador correspondiente o {@code null} si no existe.
     */
    public static Operator returnOperation(char symbol) {
        for (Operator op : Operator.values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        return null;
    }

    /**
     * Ejecuta la operación aritmética correspondiente.
     *
     * @param a operando izquierdo.
     * @param b operando derecho.
     * @return resultado de la operación.
     */
    abstract public int operate(int a, int b);
}
