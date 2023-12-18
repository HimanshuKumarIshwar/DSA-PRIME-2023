package binaryTree3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MainClass {

    public static void main(String[] args) {

       Node n1 =new Node(1);
       Node n2 =new Node(2);
        Node n3 =new Node(3);
        Node n4 =new Node(4);
        Node n5 =new Node(5);
        Node root =n1;
        n1.left =n2;
        n1.right =n3;
        n2.right =n5;
        n3.right =n4;

        List<Integer> ans =new ArrayList<>();

        //printRightView(root,ans,0);

        System.out.println(levelOrderTraversal2(root));



    }

    static void printRightView(Node root, List<Integer> ans, int level){
        if(root==null)return;
        if(level>=ans.size()){
            ans.add(root.data);
        }
        printRightView(root.right,ans,level+1);
        printRightView(root.left,ans,level+1);
    }
    static ArrayList<Integer> levelOrderTraversal(Node root){
        ArrayList<Integer> ans =new ArrayList<>();
        Queue<Node> q =new LinkedList<>();
        if(root==null)return ans;

        q.offer(root);

        while(!q.isEmpty()){
           Node cur =q.poll();
           ans.add(cur.data);
          if(cur.left!=null)q.offer(cur.left);
          if(cur.right!=null)q.offer(cur.right);
        }
return ans;
    }

static ArrayList<ArrayList<Integer>> levelOrderTraversal2(Node root){
        ArrayList<ArrayList<Integer>>ans =new ArrayList<>();
        Queue<Node> q =new LinkedList<>();
        if(root==null)return ans;

        q.add(root);
        q.add(null);
       ArrayList<Integer>curList =new ArrayList<>();

        while(!q.isEmpty()){
            Node cur =q.poll();

            if(cur==null){
            ans.add(curList);
            if(q.isEmpty())break;
            curList =new ArrayList<>();
            q.add(null);
            }else{

                curList.add(cur.data);
               if(cur.left!=null)q.add(cur.left);
               if(cur.right!=null)q.add(cur.right);
            }

        }

        return ans;



}
    static ArrayList<ArrayList<Integer>> levelOrderTraversal3(Node root){
        ArrayList<ArrayList<Integer>>ans =new ArrayList<>();
        Queue<Node> q =new LinkedList<>();
        if(root==null)return ans;

        q.add(root);



        while(!q.isEmpty()){
            int n =q.size();
            ArrayList<Integer> curList =new ArrayList<>();
          for(int i=0; i<n; i++){
              Node cur =q.poll();
              curList.add(cur.data);
              if(cur.left!=null)q.add(cur.left);
              if(cur.right!=null)q.add(cur.right);
          }
      ans.add(curList);


        }

        return ans;



    }




}
class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data =data;
    }
}