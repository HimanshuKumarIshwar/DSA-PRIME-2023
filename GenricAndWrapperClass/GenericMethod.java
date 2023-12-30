package GenricAndWrapperClass;

public class GenericMethod {
    public static void main(String[] args) {
        printInput("'Rat");
        CustomClass custom =new CustomClass();
        printInput(custom);
    }
    static<E> void printInput(E s){
        System.out.println(s);
    }
}
   class CustomClass{

   }