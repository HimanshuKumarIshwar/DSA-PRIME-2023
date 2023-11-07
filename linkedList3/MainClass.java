package linkedList3;

public class MainClass {
    public static void main(String[] args) {
       Node<Integer> n1 =new Node<>(1);
       Node<Integer> n2 =new Node<>(2);
       Node<Integer> n3 =new Node<>(3);
       Node<Integer> n4 =new Node<>(4);
       n1.next =n2;
       n2.next =n3;
       n3.next =n4;
       Node<Integer> head =n1;




    }


}
class Node<E>{
    E data;
    Node<E> next;

    public Node(E data){
        this.data =data;
    }
}
