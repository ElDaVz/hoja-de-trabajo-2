package app;

public class InfixConverter {

    private final Stack<Character> stack;

    public InfixConverter(Stack<Character> stack) {
        this.stack = stack;
        this.stack.push('#');
    }

    private int precedence(char op) {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

    public String convert(String infix){

        while (!stack.isEmpty()) stack.pop();
        stack.push('#');

        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++){
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)){
                postfix.append(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (stack.peek() != '('){
                    postfix.append(stack.pop());
                }
                stack.pop();
            }
            else if (Operator.returnOperation(ch) != null) {
                while (precedence(ch) <= precedence(stack.peek())){
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (stack.peek() != '#') {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }
}