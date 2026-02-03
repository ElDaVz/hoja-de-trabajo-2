package app;

public class PostFixCalculator implements Calc{
    private int INITIAL_MAX_LENGTH = 10;
    

    @Override
    public int operate(String input) {

        Stack<Integer> stack = new StackVector<>(INITIAL_MAX_LENGTH);

        for(int i = 0; i < input.length(); i++){
            var token = input.charAt(i);

            if (Character.isDigit(token)) {
                stack.push(Character.getNumericValue(token));
            }

            if (Operator.returnOperation(token) != null) {
                var operandoB = stack.pop();
                var operandoA = stack.pop();

                var op = Operator.returnOperation(token);

                var resultado = op.operate(operandoA, operandoB);
                stack.push(resultado);
            }

        }
        return stack.peek();
    }
}
