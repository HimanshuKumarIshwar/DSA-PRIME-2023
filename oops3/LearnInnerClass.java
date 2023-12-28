package oops3;

public class LearnInnerClass {
     class Toy{
        int price;
    }
  static  class PlayStation{
         int price;
    }

    public static void main(String[] args) {
        LearnInnerClass obj =new LearnInnerClass();

        Toy toy = obj.new Toy();
        toy.price =12;



        PlayStation playStation =new PlayStation();
    }
}
