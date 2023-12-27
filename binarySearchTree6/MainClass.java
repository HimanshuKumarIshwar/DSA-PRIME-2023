package binarySearchTree6;

public class MainClass {
    static Node prev =null;
    static int min =Integer.MAX_VALUE;
    public static void main(String[] args) {
          Node n1 =new Node(16);
          Node n2 =new  Node(7);
          Node  n3 =new  Node(20);
          Node n4 =new  Node(1);
          Node n5 =new Node(10);

          Node root =n1;
          n1.left=n2;
          n1.right =n3;
          n2.left =n4;
          n2.right =n5;

          //printInRange(root,13,23);
        System.out.println(minAbsoluteDiff(root));
    }

    static int minAbsoluteDiff(Node root){
        minAbsoluteDiffUtil(root);
        return min;
    }
    static void minAbsoluteDiffUtil(Node root){

        if(root==null)return;
        minAbsoluteDiffUtil(root.left);
        if(prev!=null){
            min =Math.min(min,root.data-prev.data);
        }
        prev =root;
        minAbsoluteDiffUtil(root.right);
    }
    static void printInRange(Node root, int min, int max){
        if(root==null)return;
        if(root.data>min){
            printInRange(root.left,min, max);

        }
   if(root.data> min && root.data<max){
       System.out.print(root.data +" ");
   }
   if(root.data<max){
       printInRange(root.right, min, max);
   }


    }
}
class Node {
    int data;
    Node left,right;
    public Node(int data){
        this.data =data;
    }
}