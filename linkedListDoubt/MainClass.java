package linkedListDoubt;

public class MainClass {
    public static void main(String[] args) {
      Node head =new Node(1);
      Node n1=new Node(2);
      Node n2 =new Node(3);
      Node n3 =new Node(4);
      Node n4 =new Node(5);
      head.next =n1;
      n1.next =n2;
      n2.next=n3;
      n3.next =n4;
    int k=3;
printLL(head);
Node reverseKTimes = reverseGroups(head,k);
printLL(reverseKTimes);

    }
    static Node reverseGroups(Node head, int k){
        Node dummy =new Node(-1);
        dummy.next =head;
        Node prevTail =dummy;
        Node curHead =head;
        while(curHead!=null){
            Node curTail =findTailAfterK(curHead,k);
            if(curTail==null)break;
            Node nextHead =curTail.next;
            reverseKTimes(curHead, k);
            prevTail.next =curTail;
            prevTail =curHead;
            curHead =nextHead;


        }
        prevTail.next =curHead;
        return dummy.next;

    }
    static  Node reverseKTimes(Node head, int k){
        if(head==null || head.next==null)return head;
        Node prev =null;
        Node cur =head;
       int  i=0;
       while(i<k && cur!=null){
           Node next =cur.next;
           cur.next =prev;
           prev =cur;
           cur =next;
           i++;
       }
       return prev;

    }
    static Node findTailAfterK(Node head, int k){

       for(int i=1; i<k; i++){
           head =head.next;
           if(head==null)return null;

       }
       return head;
    }

    static void printLL(Node head){
        Node cur =head;
        while(cur!=null){
            System.out.print(cur.data+"->");
            cur =cur.next;

        }
        System.out.println();
    }
}
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data =data;
    }
}
