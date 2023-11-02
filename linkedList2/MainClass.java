package linkedList2;

public class MainClass {
    public static void main(String[] args) {
        Node<Integer> n1 =new Node<>(1);
        Node<Integer> n2 =new Node<>(1);
        Node<Integer> n3 =new Node<>(2);
        Node <Integer> n4 =new Node<>(2);
        Node<Integer> n5 =new Node<>(5);
        Node<Integer> n6 =new Node<>(5);
        n1.next=n2;
        n2.next=n3;
        n3.next =n4;
        n4.next =n5;
        n5.next =n6;
        Node<Integer> head =n1;
        printLL(head);
        //System.out.println(findMiddleNode(head).data);
        Node <Integer> newHead =removeDuplicate(head);
        printLL(newHead);
    }

    static Node<Integer> removeDuplicate(Node<Integer> head){

        Node<Integer> cur =head;
        while(cur!=null){
            Node<Integer> temp =cur;
            while( temp.next!=null && temp.data == temp.next.data){
                temp =temp.next;
            }
            cur.next =temp.next;

            cur =cur.next;

        }
        return head;
    }

    static Node<Integer> findMiddleNode(Node<Integer> head){
        Node<Integer> slow =head;
        Node<Integer> fast =head;
        while(fast!=null && fast.next!=null){
            slow =slow.next;
            fast =fast.next.next;
        }
        return slow;
    }
    static void printLL(Node<Integer> head){
        while(head!=null){
            System.out.print(head.data+"->");
            head =head.next;
        }
        System.out.println("end");
    }

}

class Node<E> {
    E data;
    Node<E> next;
    public Node(E data){
        this.data =data;

    }
}
