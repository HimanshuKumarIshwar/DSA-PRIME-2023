package exceptionHandling;

public class FinallyBlockInExceptions {
    public static void main(String[] args) {
        int a[] =new int[5];
//        System.out.println("Hello world");
//
//        try{
//            System.out.println(a[8]);
//        }catch(Exception e){
//            System.out.println("Exception handled");
//        }finally {
//            System.out.println("I will run always");
//        }
//        System.out.println("Bye world");


  try{
      getNumberFromArray(a);
  }catch (Exception e){
      System.out.println(e.getMessage());
  }







    }


    static int getNumberFromArray(int a[]) throws ArithmeticException{
        return a[8];
    }
}
