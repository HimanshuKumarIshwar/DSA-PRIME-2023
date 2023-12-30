package GenricAndWrapperClass;

public class LearnGenerics {

    public static void main(String[] args) {
         Dog<String,String> d1 =new Dog<>("One", "haski");

//         Dog<String> d2 =new Dog<>("two");
//
//         Dog<Integer> d3 =new Dog<>(12);





    }

}
//class Dog<T>{
//    T id;
//
//
//    public Dog(T id){
//        T.id =id;
//    }
//}


class Dog<T,V> {
    T id;
    V name;

    public Dog(T id, V name){
        this.id =id;
        this.name =name;
    }

}