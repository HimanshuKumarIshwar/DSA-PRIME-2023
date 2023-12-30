package exceptionHandling;

import java.util.Scanner;

public class CustomException {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the Age");
        int age = sc.nextInt();
        try{
            if(age > 100){
                //throw new MyException("My error is this");
                throw new ArithmeticException("More then 100 is not allowed");
            }

            }catch(Exception e){
            System.out.println(e);
        }



    }
}
class MyException extends Exception {
 public MyException(String message){
   super(message);
 }
}
