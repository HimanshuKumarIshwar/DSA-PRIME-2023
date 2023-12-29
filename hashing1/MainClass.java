package hashing1;
import java.util.*;
import java.util.Objects;

public class MainClass {
    public static void main(String[] args) {
        String s ="abc";

        System.out.println(s.hashCode());

//        Boolean bol =true;
//        System.out.println(bol.hashCode());

//        Integer a =12;
//        System.out.println(a.hashCode());

Boy b1 =new Boy(25,"Anuj");
Boy b2 =b1;
Boy b3 =new Boy(23, "Anuj");
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        System.out.println(b3.hashCode());

        HashMap<Integer, String> map =new HashMap<>();
        map.put(12, "Himanshu");
    }


static class Boy{
        int age;
        String name;

      public Boy(int age, String name){
          this.age =age;
          this.name =name;
      }


      @Override
     public int hashCode(){
        return Objects.hash(name, age);
}



}

}
