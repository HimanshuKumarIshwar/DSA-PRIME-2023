package binarySearchTree1;

public class MainClass {

    public static void main(String[] args) {
        Node n1 =new Node(8);
        Node n2 =new Node(3);
        Node n3 =new Node(10);
        Node n4 =new Node(1);
        Node n5 = new Node(6);
        Node n6 = new Node(4);

        Node root =n1;
        n1.left =n2;
        n1.right = n3;
        n2.left =n4;
        n2.right =n5;
        n5.left =n6;
//        System.out.println(search(root,4));
//        printInorder(root);
//        Node newNode =insert(root,5);
//        System.out.println();
//        printInorder(newNode);


        printInorder(root);
        System.out.println();
       root = delete(root,10);
       printInorder(root);
    }

    static Node delete(Node root, int key){
        if(root == null)return null;
        if(root.data > key){
            root.left =delete(root.left,key);
        }else if(root.data < key){
            root.right = delete(root.right, key);
        }

        else {
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            Node successor = inorderSuccessor(root.right);

            root.data = successor.data;

           root.right = delete(root.right, successor.data);


        }
        return root;

    }


    static Node inorderSuccessor(Node root){
        Node temp =root;
        while(temp.left != null){
            temp =temp.left;
        }
        return temp;
    }


    static Node insert(Node root, int key){
        if(root == null)return new Node(key);
        if(root.data > key){
            root.left =insert(root.left, key);
        }
        else if(root.data < key){
            root.right =insert(root.right, key);
        }
        return root;

    }

    static void printInorder(Node root){
        if(root == null)return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }

    static boolean search(Node root, int key){
        if(root == null)return false;
        if(root.data < key){
            return search(root.right, key);
        }
        if(root.data > key){
            return search(root.left, key);
        }
        return true;
    }
}

class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data =data;
    }
}
