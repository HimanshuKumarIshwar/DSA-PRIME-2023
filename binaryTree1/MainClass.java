package binaryTree1;

public class MainClass {
    public static void main(String[] args) {
Node n1 =new Node(1);
Node n2 =new Node(4);
Node n3=new Node(5);
Node n4 =new Node(6);
Node n5 =new  Node(8);
Node n6 =new Node(2);
Node root =n1;
n1.left =n2;
n1.right  =n3;
n2.left =n4;
n2.right =n5;
n3.left =n6;


//inorder(root);
      //  preorder(root);
//postorder(root);
      //  System.out.println(minimumInTree(root));

        System.out.println(height(root));


    }

    static void inorder(Node root){
        if(root==null)return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);


    }
    static void preorder(Node root){
        if(root==null)return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);

    }
    static void postorder(Node root){
        if(root==null)return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }
    static int minimumInTree(Node root){
        if(root==null)return Integer.MAX_VALUE;
        int minLeft =minimumInTree(root.left);
        int minRight =minimumInTree(root.right);
        return Math.min(Math.min(minLeft,minRight),root.data);
    }

    static int height(Node root){
        if(root==null)return 0;
        int hl =height(root.left);
        int hr =height(root.right);
        return Math.max(hl,hr)+1;
    }



}
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
