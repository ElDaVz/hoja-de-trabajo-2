package app;

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
                return 0;
            }
        }
    };

    private final char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public static Operator returnOperation(char symbol) {
        for (Operator op : Operator.values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        return null;
    }

    abstract public int operate(int a, int b);
}
