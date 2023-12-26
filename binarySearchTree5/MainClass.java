package binarySearchTree5;

public class MainClass {

    public static void main(String[] args) {

    }
    static int height(Node a){
        int leftHeight = a.left==null ? 0:a.left.height;
        int rightHeight =a.right==null ?0 : a.right.height;
        return Math.max(leftHeight,rightHeight)+1;
    }

    static Node leftRotate (Node x){
        Node  y =x.right;
        Node A =y.left;
        y.left =x;
        x.right =A;
        x.height =height(x);
        y.height =height(y);
        return y;

    }
    static Node rightRotate(Node x){
        Node y =x.left;
        Node A =y.right;
        y.right =x;
        x.left =A;
        x.height =height(x);
        y.height =height(y);
        return y;
    }

    static Node insertAVL(Node root, int key){
        if(root == null)return new Node(key);
        if(key < root.data){
            root.left =insertAVL(root.left,key);
        } else if(key > root.data){
            root.right =insertAVL(root.right, key);
        }
        else {
            return root;
        }



        root.height =height(root);
        int hb =height(root.left) - height(root.right);
        if(hb > 1 && key < root.left.data){
            return rightRotate(root);
        }
        if(hb < -1 && key > root.right.data){
            return leftRotate(root);
        }

        if(hb > 1 && key > root.left.data){
            root.left =leftRotate(root.left);
            return rightRotate(root);
        }
        if(hb < -1 && key < root.right.data){
            root.right =rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
}

class Node {
    int data, height;
    Node left, right;
    public Node(int data){
        this.data =data;
    }
}
