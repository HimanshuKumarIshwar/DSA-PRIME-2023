package binarySearchTree4;

public class MainClass {
    public static void main(String[] args) {
       // int a[] ={1,3,4,5,6,7,9};
        //Node root =convertINBalancedBST(a,0,a.length-1);
       // printInorderTraversal(root);


        int a[] ={8,5,1,7,10,12};
        Node root = createBSTFromPreorder(a,0,a.length-1);
        printInorderTraversal(root);
    }



    static Node createBSTFromPreorder(int a[], int l,int r){
        if(l>r)return null;
        Node root =new Node(a[l]);
        int i=l+1;
        for(; i<=r; i++){
            if(a[i]>a[l])break;
        }

        root.left =createBSTFromPreorder(a,l+1,i-1);
        root.right =createBSTFromPreorder(a,i,r);
        return root;

    }
    static Node convertINBalancedBST(int a[], int l,int r){
        if(l>r)return null;
        int mid =l+(r-l)/2;
        Node root =new Node(a[mid]);
        root.left =convertINBalancedBST(a,l,mid-1);
        root.right =convertINBalancedBST(a,mid+1,r);
        return root;
    }

    static void printInorderTraversal(Node root){
        if(root == null)return;
        printInorderTraversal(root.left);
        System.out.print(root.data +" ");
        printInorderTraversal(root.right);
    }
}

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data =data;
    }
}
