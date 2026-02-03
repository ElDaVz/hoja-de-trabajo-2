package app;

public class PostFixCalculator implements Calc{
    private int INITIAL_MAX_LENGTH = 10;
    @Override
    public int operate(String input) {
        var OPERAND_COUNT = 0;
        Stack<Integer> stack = new StackVector<>(INITIAL_MAX_LENGTH);

        for(int i = 0; i < input.length(); i++){
            var token = input.charAt(i);

            if (Character.isDigit(token)) {
                stack.push(Character.getNumericValue(token));
                OPERAND_COUNT++;
            }

            else if (Operator.returnOperation(token) != null) {
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
