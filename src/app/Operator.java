package app;

public enum Operator {

    SUMA{
        @Override
        public int operate(int a, int b) {
            return a + b;
        }

    },
    RESTA{
        @Override
        public int operate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLICACION{
        @Override
        public int operate(int a, int b) {
            return a * b;
        }
    },
    DIVISION{
        @Override
        public int operate(int a, int b) {
            try {
                return a / b;
            } catch (ArithmeticException e) {
                return 0;
            }
        }
    };

    private String symbol;

    abstract public int operate(int a, int b);
}
