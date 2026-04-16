
import java.util.Stack;

public class ExpressionConverter {

    // Function to return precedence of operators
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Function to convert infix expression to postfix expression
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);

            // If the scanned character is an operand, add it to the output.
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression"; // Invalid expression
                } else {
                    stack.pop();
                }
            } else { // An operator is encountered
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    if (stack.peek() == '(') {
                        return "Invalid Expression";
                    }
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the remaining operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result.append(stack.pop());
        }
        return result.toString();
    }

    // Function to reverse a string
    static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    // Function to convert infix expression to prefix expression
    public static String infixToPrefix(String expression) {
        // Reverse the infix expression
        String reversedInfix = reverseString(expression);

        // Replace '(' with ')' and vice versa
        StringBuilder modifiedInfix = new StringBuilder();
        for (char c : reversedInfix.toCharArray()) {
            if (c == '(') {
                modifiedInfix.append(')');
            } else if (c == ')') {
                modifiedInfix.append('(');
            } else {
                modifiedInfix.append(c);
            }
        }

        // Get postfix of the modified infix expression
        String postfix = infixToPostfix(modifiedInfix.toString());

        // Reverse the postfix expression to get prefix
        return reverseString(postfix);
    }

    public static void main(String[] args) {
        String infixExpression = "a+b*(c-d)/e";
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + infixToPostfix(infixExpression));
        System.out.println("Prefix Expression: " + infixToPrefix(infixExpression));

        infixExpression = "(a-b/c)*(a/k-l)";
        System.out.println("\nInfix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + infixToPostfix(infixExpression));
        System.out.println("Prefix Expression: " + infixToPrefix(infixExpression));
    }
}
