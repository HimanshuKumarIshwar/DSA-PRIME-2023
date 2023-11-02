package linkedList1;

public class MainClass {
    public static void main(String[] args) {
        Node<Integer> n1 =new Node<>(1);
        Node<Integer> n2 =new Node<>(2);
        Node<Integer> n3 =new Node<>(3);
        Node<Integer> n4 =new Node<>(4);
        Node<Integer>n5 =new Node<>(5);
        Node<Integer> head =n1;
        n1.next =n2;
        n2.next =n3;
        n3.next =n4;
        n4.next =n5;
        printLL(head);
 // Node<Integer> newHead = deleteLL(head, 4);
        Node<Integer> newHead = insertLL(head, 40,0);
       printLL(newHead);


    }
    static Node<Integer> deleteLL(Node<Integer> head, int pos){
        if(pos==0){
            return head =head.next;
        }
        Node<Integer> temp =head;
        for(int i=0; i<pos-1; i++){
            temp =temp.next;
        }
        temp.next =temp.next.next;
        return head;
    }

    static Node<Integer> insertLL(Node<Integer> head,int data, int pos){
        Node<Integer> newNode = new Node<>(data);
        if(pos==0){
            newNode.next =head;
            return newNode;
        }
        Node<Integer> temp =head;

        for(int i=0; i<pos-1; i++){
            temp=temp.next;
        }

        Node<Integer> nextNode =temp.next;
        temp.next=newNode;
        newNode.next =nextNode;

        return head;
    }
    static void printLL(Node<Integer> head){
        Node<Integer> temp =head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp =temp.next;
        }
        System.out.println("null");
    }
}


class Node<E>{
    E data;
    Node<E> next;
    public Node(E data){
        this.data =data;
        next=null;
    }
}

