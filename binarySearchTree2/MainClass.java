package binarySearchTree2;

public class MainClass {
    public static void main(String[] args) {
       Node n1 =new  Node(8);
       Node n2 =new  Node(4);
       Node n3 = new  Node(10);
       Node n4 =new  Node(1);
       Node n5= new  Node(6);
       Node n6 = new Node(14);
       Node n7 = new  Node(7);

       Node root = n1;
       n1.left =n2;
       n1.right =n3;
       n2.left =n4;
       n2.right =n5;
       n3.right =n6;
       n5.right =n7;

    Node prede =inorderPredecessor(root,1,null);
    if(prede == null){
        System.out.println("Not found");
    } else{
        System.out.println(prede.data);
    }


    }


    static Node inorderPredecessor(Node root, int key, Node predecessor){
        if(root == null)return null;
        if(root.data > key){
            return inorderPredecessor(root.left, key, predecessor);
        }
        else if(root.data < key){
            return inorderPredecessor(root.right,key,root);
        }
        else {
            if(root.left==null){
                return predecessor;
            }
            else{
                return largest(root.left);
            }
        }



    }

    static Node largest(Node root){
        Node temp = root;
        while(temp.right != null){
            temp =temp.right;
        }
        return temp;
    }
    static boolean isBst(Node root, int min, int max){
        if(root == null)return true;
        if(root.data >= max || root.data <=min)return false;

        return isBst(root.left,min , root.data)  && isBst(root.right, root.data, max);
    }
}

class Node {
    int data;
    Node left;
    Node right;
    public  Node(int data){
        this.data =data;
    }
}
