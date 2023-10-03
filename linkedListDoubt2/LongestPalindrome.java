package linkedListDoubt2;

public class LongestPalindrome {
    public static void main(String[] args) {
        Node head =new Node(1);
        Node n1 =new  Node(2);
        Node n2 =new Node(3);
        Node n3 =new Node(2);
        Node n4 =new Node(4);
        head.next =n1;
        n1.next =n2;
        n2.next =n3;
        n3.next =n4;

        printLL(head);

        System.out.println(longestPalindromeList(head));



    }
    static int longestPalindromeList(Node head){
        if(head==null)return 0;
        if(head.next ==null)return 1;
        int ans =0;
        Node prev =null;
        Node cur =head;
        while(cur!=null){
            Node next =cur.next;
            cur.next =prev;
            int commonIfCurIsExactCenter =countCommon(prev,next);
            int lengthenExactCenter =2*commonIfCurIsExactCenter+1;
            int commonIfCurIsNotExactCenter =countCommon(cur,next);
            int lengthFromCurIsNotCenter =2*commonIfCurIsNotExactCenter;
            int maxLength =Math.max(lengthenExactCenter,lengthFromCurIsNotCenter);
            ans =Math.max(maxLength,ans);

            prev =cur;
            cur =next;



        }
        return ans;
    }
    static void printLL(Node head){
        while(head!=null){
            System.out.print(head.data+"-> ");
            head =head.next;
        }
        System.out.println("Null");
    }
    static int countCommon(Node a, Node b){
        int count =0;
        while(a!=null && b!=null){
            if(a.data==b.data){
                count++;
                a= a.next;
                b =b.next;

            }else break;
        }
        return count;
    }
}
