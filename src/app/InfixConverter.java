package app;

public class InfixConverter {

    private int precedence(char op) {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

    public String convert(String infix){
        Stack<Character> stack = new StackO<>(10);
        StringBuilder postfix = new StringBuilder();
        stack.push('#');

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