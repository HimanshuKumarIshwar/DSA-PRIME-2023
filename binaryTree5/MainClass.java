package binaryTree5;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        Node n1 =new Node(3);
        Node n2 =new Node(5);
        Node n3 =new Node(1);
        Node n4 =new Node(6);
        Node n5 =new Node(2);
        Node n6 =new Node(0 );
        Node n7 =new Node(8);
        Node n8 =new Node(7);
        Node n9 =new Node(4);


        Node root =n1;
        n1.left =n2;
        n1.right =n3;
        n2.left =n4;
        n2.right =n5;
        n3.left =n6;
        n3.right =n7;
        n5.left =n8;
        n5.right =n9;

//        ArrayList<Integer> ans =new ArrayList<>();
//        isAncestors(root,7,ans);
//        System.out.println(ans);

       // System.out.println(lca(root,7,4).data);

        System.out.println(distanceBetweenTwoNodes(root,4,7));
        System.out.println(distanceBetweenTwoNodes2(root,4,7));

    }
static int distanceBetweenTwoNodes(Node root, int a,int b){
        Node lca =lca(root,a,b);
        Integer distanceA =height(root,a);
        Integer distanceB =height(root,b);
        Integer distanceLca =height(root,lca.data);

        return distanceA+distanceB- 2*distanceLca;
}

static int distanceBetweenTwoNodes2(Node root,int a,int b){
        Node lca =lca(root,a,b);
        return height(lca,a)+height(lca,b);
}
    static Integer height(Node root,int a){
        if(root==null)return null;
        if(root.data==a)return 0;
        Integer left =height(root.left,a);
        Integer right =height(root.right,a);
        if(left==null && right==null)return null;
        if(left==null)return right+1;
        if(right==null)return left+1;

        return null;

    }

static Node lca(Node root, int a, int  b){
        if(root==null)return null;
        if(root.data==a || root.data==b)return root;
        Node left =lca(root.left,a,b);
        Node right =lca(root.right,a,b);
        if(left==null)return right;
        if(right==null)return left;

        return root;
}

    static boolean isAncestors(Node root, int target, ArrayList<Integer> ans){
        if(root==null)return false;
        if(root.data ==target)return true;
        boolean isPresentLeft =isAncestors(root.left,target,ans);
        boolean isPresentRight =isAncestors(root.right,target,ans);
        if(isPresentLeft || isPresentRight){
            ans.add(root.data);
            return true;
        }
       return false;
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
