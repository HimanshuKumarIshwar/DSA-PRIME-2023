package linkedListDoubt2;

public class Mainclass {
    public static void main(String[] args) {
        Node head =new  Node(1);
        Node n1 =new Node(4);
        Node n2 =new Node(3);
        Node n3 =new Node(2);
        Node n4 =new Node(5);
        Node n5 =new Node(2);
        head.next =n1;
        n1.next =n2;
        n2.next =n3;
        n3.next =n4;
        n4.next =n5;
        printLL(head);
        Node ans =partitionLL(head,3);
        printLL(ans);



    }

    static Node partitionLL(Node head, int data){
        if(head==null || head.next==null)return head;
        Node dummyS =new Node(-1);
        Node dummyL =new Node(-1);
        Node sHead =dummyS;
        Node sTail =dummyS;
        Node lHead =dummyL;
        Node lTail=dummyL;


        while(head!=null){
            if(head.data<data){
                sTail.next =head;
                sTail =head;
            }else{
                lTail.next =head;
                lTail =head;
            }
            head =head.next;
        }
        sTail.next =lHead.next;
        lTail.next =null;
        return sHead.next;

    }

    static void printLL(Node head){
        while(head!=null){
            System.out.print(head.data+"-> ");
            head =head.next;
        }
        System.out.println("null");
    }
}
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data =data;
    }
}

