package app;
/**
 * Implementación de una calculadora para expresiones en notación postfix.
 * La evaluación se realiza utilizando una pila y un contador lógico
 * para validar la corrección de la expresión sin depender
 * de la implementación interna de la pila.
 */
public class Calculator implements Calc{

    private static Calculator instance;
    private int stackOpcion;
    private int listOpcion;

    private Calculator(int stackOpcion, int listOpcion) {
        this.stackOpcion = stackOpcion;
        this.listOpcion  = listOpcion;
    }

    public static Calculator getInstance(int stackOpcion, int listOpcion) {
        if (instance == null) {
            instance = new Calculator(stackOpcion, listOpcion);
        }
        return instance;
    }

    /**
     * Evalúa una expresión postfix token por token.
     *
     * @param input expresión postfix a evaluar.
     * @return resultado de la expresión.
     * @throws ArithmeticException si la expresión es inválida.
     */
    @Override
    public double operate(String input) {
        Stack<Integer> stack = StackFactory.create(stackOpcion, listOpcion);
        while (!stack.isEmpty()) stack.pop();

        var OPERAND_COUNT = 0;

        for (var tokenStr : input.trim().split("\\s+")) {
            if (tokenStr.isEmpty()) continue;
            var isOperator = tokenStr.length() == 1
                    && Operator.returnOperation(tokenStr.charAt(0)) != null;

            if (!isOperator) {
                stack.push(Integer.parseInt(tokenStr));
                OPERAND_COUNT++;
            }

            else {
                if (OPERAND_COUNT < 2) {
                    throw new ArithmeticException("Operandos insuficientes para el operador: " + tokenStr);
                }

                var operandoB = stack.pop();
                var operandoA = stack.pop();

                var op = Operator.returnOperation(tokenStr.charAt(0));
                var resultado = op.operate(operandoA, operandoB);

                stack.push(resultado);
                OPERAND_COUNT--;
            }
        }

        if (OPERAND_COUNT == 1) {
            return stack.peek();
        }
        else {
            throw new ArithmeticException("Operacion no encontrada");
        }
    }
}