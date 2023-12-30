package exceptionHandling;

public class MainClass  {
    public static void main(String[] args) {
        int []a = new  int[5];


        System.out.println("Hello guys");

//        try{
//            int result =5/0;
//            System.out.println(a[6]);
//
//        }catch(ArrayIndexOutOfBoundsException e){
//            System.out.println("Trie to excess Out of the bound element");
//        } catch(ArithmeticException e){
//            System.out.println(e.getStackTrace());
//            System.out.println(e.getMessage());
//            System.out.println(e);
//        }

        try {
            int result = 5 / 0;
            System.out.println(a[6]);

//        }catch(ArrayIndexOutOfBoundsException | ArithmeticException |NullPointerException e){
//            System.out.println("Handling the exception");
//        } catch(RuntimeException e){
//
//        }
        }catch (Exception e){
            System.out.println("All type exception handling");
        }



        System.out.println("Buy guys");

    }
}
