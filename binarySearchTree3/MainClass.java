package binarySearchTree3;

import java.util.ArrayDeque;

public class MainClass {
    public static void main(String[] args) {
        Node n1 =new Node(8);
        Node n2 =new Node(4) ;
        Node n3 =new Node(10);
        Node n4 =new Node(1);
        Node n5= new Node(6);
        Node n6 = new Node(14);
        Node n7 = new Node(7);

Node root = n1;
        n1.left =n2;
        n1.right =n3;
        n2.left =n4;
        n2.right =n5;
        n3.right =n6;
        n5.right =n7;
//printInorderTraversalIteratively(root);
        System.out.println(isSumBst(root,70));

    }

    static boolean isSumBst(Node root, int target){
        if(root ==null)return false;
        Node cur1 =root;
        Node cur2 =root;
        boolean done1 =false;
        boolean done2 =false;
        int val1 =0;
        int val2 =0;
        ArrayDeque<Node> s1 = new ArrayDeque<>();
        ArrayDeque<Node> s2 = new ArrayDeque<>();
        while(true){

            //LNR Traversal
            while(done1==false){
                if(cur1!=null){
                    s1.push(cur1);
                    cur1 =cur1.left;
                }else{
                    if(s1.isEmpty()){
                        done1 =true;
                    }else{
                        Node pop =s1.pop();
                        val1 =pop.data;
                        cur1 =pop.right;
                        done1 =true;
                    }

                }
            }

            //RNL Traversal

            while(done2==false){
                if(cur2!=null){
                    s2.push(cur2);
                    cur2 =cur2.right;
                }else{
                    if(s2.isEmpty()){
                        done2 =true;
                    }else{
                        Node pop =s2.pop();
                        val2 =pop.data;
                        cur2 =pop.left;
                        done2 =true;
                    }

                }
            }

            // checking condition

            if(val1!=val2 && val1+val2==target){
                return true;
            }
            if( val1 + val2 > target){
                done2 =false;
            }else if( val1 + val2 < target){
                 done1 =false;
            }

            if(val1>=val2)return false;

        }
    }


    static void printInorderTraversalIteratively(Node root){
        if(root==null)return;
        ArrayDeque<Node> stack  =new ArrayDeque<>();
        Node cur =root;

        while(!stack.isEmpty() || cur!=null){

            while(cur!=null){
                stack.push(cur);
                cur =cur.left;
            }
            Node pop =stack.pop();
            System.out.print(pop.data+" ");
            cur =pop.right;

        }
    }


}
class Node {
    int data;
    Node left;
    Node right;
    public Node (int data){
        this.data =data;
    }
}
