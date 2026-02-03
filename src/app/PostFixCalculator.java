package app;
/**
 * Implementación de una calculadora para expresiones en notación postfix.
 * La evaluación se realiza utilizando una pila y un contador lógico
 * para validar la corrección de la expresión sin depender
 * de la implementación interna de la pila.
 */
public class PostFixCalculator implements Calc{
    private int INITIAL_MAX_LENGTH = 10;

    /**
     * Evalúa una expresión postfix carácter por carácter.
     *
     * @param input expresión postfix a evaluar.
     * @return resultado de la expresión.
     * @throws ArithmeticException si la expresión es inválida.
     */
    @Override
    public int operate(String input) {
        var OPERAND_COUNT = 0;
        Stack<Integer> stack = new StackVector<>(INITIAL_MAX_LENGTH);

        for(int i = 0; i < input.length(); i++){
            var token = input.charAt(i);
            var isOperator = Operator.returnOperation(token) != null;


            if (Character.isDigit(token)) {
                stack.push(Character.getNumericValue(token));
                OPERAND_COUNT++;
            }

            else if (isOperator) {
                if (OPERAND_COUNT < 2) {
                    throw new ArithmeticException("Operandos insuficientes para el operador: " + token);
                }

                var operandoB = stack.pop();
                var operandoA = stack.pop();

                var op = Operator.returnOperation(token);
                var resultado = op.operate(operandoA, operandoB);

                stack.push(resultado);
                OPERAND_COUNT--;
            }
            else {
                throw new IllegalArgumentException("Token invalido: " + token);
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
