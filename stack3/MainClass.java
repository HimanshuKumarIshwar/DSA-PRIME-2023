package stack3;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        String s ="3 4 * 2 5 * +";
        System.out.println(evaluatePostfixExpression(s));
    }
    static int evaluatePostfixExpression(String s){
        ArrayDeque<Integer> stack =new ArrayDeque<>();
        String []tokens =s.split(" ");
        for(String e: tokens){
            if(isOperator(e)){
                int secondOperand =stack.pop();
                int firstOperand =stack.pop();
                int result=0;
              switch(e){
                  case "+":
                      result =firstOperand+secondOperand;
                      break;
                  case "-":
                      result =firstOperand-secondOperand;
                      break;
                  case "*":
                      result =firstOperand*secondOperand;
                      break;
                  case "/":
                      result =firstOperand/secondOperand;
                      break;
                  case "^":
                      result = (int)Math.pow(firstOperand,secondOperand);
                      break;

              }
              stack.push(result);

            }else{
                stack.push(Integer.parseInt(e));
            }
        }
        return stack.pop();
    }
    static boolean isOperator(String s){
        return s.equals("+")||s.equals("-")|| s.equals("*")||s.equals("/")||s.equals("^");
    }
}
