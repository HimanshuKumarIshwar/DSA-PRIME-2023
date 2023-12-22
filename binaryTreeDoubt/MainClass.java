package binaryTreeDoubt;
import java.util.*;
public class MainClass {

    public static void main(String[] args) {
   Node n1 =new Node(10);
   Node n2 =new Node(5);
   Node n3 =new  Node(3);
   Node n4 =new Node(7);
   Node n5 =new Node(9);
   Node n6 =new Node(2);
   Node n7 =new Node(6);
   Node n8 =new Node(4);
   Node n9 =new  Node(1);


   Node root =n1;
   n1.left =n2;
   n1.right =n3;
   n2.left =n4;
   n2.right =n5;
   n3.right =n6;
   n5.left =n7;
   n5.right =n8;
   n6.left =n9;

//inorderTraversal(root);
//        System.out.println();
//Node head =convertBinarytreeInLL(root);
//while(head!=null){
//    System.out.print(head.data+" ");
//    head =head.right;
//}

        System.out.println(distanceKFromTarget(root,3 ,2));
    }


    static void distanceKDown(Node root, int k, List<Integer> ans){
        if(root==null || k<0)return;
        if(k==0){
            ans.add(root.data);
            return;
        }

        distanceKDown(root.left,k-1,ans);
        distanceKDown(root.right,k-1,ans);


    }

static List<Integer> distanceKFromTarget(Node root, int target,int k){
        List<Integer> ans =new ArrayList<>();
        distanceKFromTarget(root,target,k, ans);
        return ans;
}


// return value is the distance of target from the root node
    static int distanceKFromTarget(Node root, int target, int k,List<Integer> ans){
        if(root==null)return -1;
        if(root.data==target){
            distanceKDown(root, k,ans);
            return 0;
        }
        // dl -> distance of left node from target , if -1 then node note found
        int dl =distanceKFromTarget(root.left,target,k,ans);
        if(dl!=-1){
            if(dl+1 == k){
                ans.add(root.data);

            }
            distanceKDown(root.right,k-dl-2,ans);
            return dl+1;
        }


  // dr -> distance og right node from target if -1 then node not found
        int dr =distanceKFromTarget(root.right,target,k,ans);
    if(dr != -1){
        if(dr+1 == k){
            ans.add(root.data);
        }
        distanceKDown(root.left,k-dr-2,ans);
        return dr+1;
    }

    return -1;


    }

    static Node convertBinarytreeInLL(Node root){
        if(root==null)return null;
        convertBinarytreeInLLUtil(root);
       while(root.left!=null) {
           root =root.left;
       }

       return root;

    }

    static Node convertBinarytreeInLLUtil(Node root){
        if(root==null)return null;

        if(root.left!=null){
            Node leftNode = convertBinarytreeInLLUtil(root.left);
            while(leftNode.right!=null){
                leftNode =leftNode.right;
            }

            leftNode.right =root;
            root.left =leftNode;
        }


        if(root.right!=null){
            Node rightNode =convertBinarytreeInLLUtil(root.right);
            while(rightNode.left!=null){
                rightNode =rightNode.left;
            }

            rightNode.left =root;
            root.right=rightNode;
        }

        return root;
    }

    static void inorderTraversal(Node root){
        if(root==null)return;
        inorderTraversal(root.left);
        System.out.print(root.data+" ");
        inorderTraversal(root.right);
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
