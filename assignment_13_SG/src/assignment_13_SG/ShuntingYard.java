package assignment_13_SG;

public class ShuntingYard {
    public LinkedList Tokens;
    public OutputQueue ReversePolish;

    public ShuntingYard(){
        this.Tokens = new LinkedList();
        this.ReversePolish = new OutputQueue();
    }

    public void parse(String input){
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                String number = Character.toString(currentChar);
                // If the next characters are digits, keep adding them to form the full number
                while (i + 1 < input.length() && (Character.isDigit(input.charAt(i + 1)) || input.charAt(i + 1) == '.')) {
                    number += input.charAt(++i);
                }
                Tokens.append(number);
            } else if ("+-*/^()".indexOf(currentChar) != -1) {
                // Operators or parentheses
                Tokens.append(Character.toString(currentChar));
            }
            // Ignore whitespace and other characters
        }
    }

    public void process(){
        Stack operatorStack = new OpStack();

        Node currentNode = Tokens.Head;
        while (currentNode != null) {
            String token = currentNode.Data;

            if (isNumber(token)) {
                ReversePolish.enqueue(token);
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() &&
                       isOperator(operatorStack.peek().Data) &&
                       hasHigherPrecedence(operatorStack.peek().Data, token)) {
                    ReversePolish.enqueue(operatorStack.pop().Data);
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().Data.equals("(")) {
                    ReversePolish.enqueue(operatorStack.pop().Data);
                }
                operatorStack.pop(); // Discard the left parenthesis
            }

            currentNode = currentNode.NextNode;
        }

        while (!operatorStack.isEmpty()) {
            ReversePolish.enqueue(operatorStack.pop().Data);
        }
    }

    // check if a string represents a number
    private boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // check if a string represents an operator
    private boolean isOperator(String str) {
        return "+-*/^".contains(str);
    }

    // check if op1 has higher precedence than op2
    private boolean hasHigherPrecedence(String op1, String op2) {
        int precedenceOp1 = getPrecedence(op1.charAt(0));
        int precedenceOp2 = getPrecedence(op2.charAt(0));
        return precedenceOp1 >= precedenceOp2;
    }
    public int run(){
        Stack operandStack = new OpStack();

        Node currentNode = ReversePolish.Head;
        while (currentNode != null) {
            String token = currentNode.Data;

            if (isNumber(token)) {
                operandStack.push(token);
            } else if (isOperator(token)) {
                int operand2 = Integer.parseInt(operandStack.pop().Data);
                int operand1 = Integer.parseInt(operandStack.pop().Data);

                int result = performOperation(operand1, operand2, token);
                operandStack.push(String.valueOf(result));
            }

            currentNode = currentNode.NextNode;
        }

        return Integer.parseInt(operandStack.pop().Data);
    }


    private int getPrecedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '^')
            return 3;
        else
            return -1;
    }

    private int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}