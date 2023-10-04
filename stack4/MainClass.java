package stack4;

import java.util.ArrayDeque;

public class MainClass {
    public static void main(String[] args) {
       String infixExpression ="a + b - d * ( e + f ) * g";
        System.out.println(convertInToPostFix(infixExpression));
    }
    static boolean isOperator(String s){
        return s.equals("+")||s.equals("-")|| s.equals("*")||s.equals("/")||s.equals("^");
    }
    static int precedence(String s){
        switch(s){
            case "^":
                return 3;
            case "/":
            case"*":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return -1;
        }
    }

    static String convertInToPostFix(String s){
        String[] tokens =s.split(" ");
        ArrayDeque<String> stack =new ArrayDeque<>();
        StringBuilder sb =new StringBuilder();
        for(String token: tokens){
            if(token.equals("(")){
                stack.push(token);
            }else if(isOperator(token)){
                   while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)){
                       sb.append(stack.pop()).append(" ");
                   }
                   stack.push(token);
            }else if(token.equals(")")){
                  while(!stack.isEmpty() && ! (stack.peek().equals("("))){
                      sb.append(stack.pop()).append(" ");

                  }
                  stack.pop();
            }else{
                sb.append(token).append(" ");
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
