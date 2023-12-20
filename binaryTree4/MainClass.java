package binaryTree4;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
       Node n1 =new Node(1);
        Node n2 =new Node(2);
        Node n3 =new Node(3);
        Node n4 =new Node(4);
        Node n5 =new Node(5);
        Node n6 =new Node(6);
        Node n7 =new Node(7);
        Node n8 =new Node(8);
        Node n9 =new Node(9);

        Node root =n1;
        n1.left =n2;
        n1.right =n3;
        n2.left =n4;
        n2.right=n5;
        n3.left =n6;
        n3.right =n7;
        n4.left =n8;
        n4.right =n9;

//        System.out.println(verticalOrderTraversal(root));
//        System.out.println(topview(root));
//        System.out.println(diameter(root));

        height(root);
        System.out.println(diameter);
    }

    static ArrayList<ArrayList<Integer>> verticalOrderTraversal(Node root){
        ArrayList<ArrayList<Integer>> ans =new ArrayList<>();
        Queue<Pair>q =new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> map =new TreeMap<>();
        if(root==null)return ans;
        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            Pair cur =q.poll();
            if(!map.containsKey(cur.hd)){
                map.put(cur.hd,new ArrayList<>());
            }
            map.get(cur.hd).add(cur.node.data);

            if(cur.node.left!=null)q.add( new Pair(cur.node.left,cur.hd-1));
            if(cur.node.right!=null)q.add( new Pair (cur.node.right,cur.hd+1));
        }
        return new ArrayList<>(map.values());
    }

    static ArrayList<Integer> topview(Node root){
        Queue<Pair> q =new LinkedList<>();
        TreeMap<Integer,Integer> map =new TreeMap<>();

        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            Pair cur =q.poll();
            if(!map.containsKey(cur.hd)){
                map.put(cur.hd,cur.node.data);
            }

            if(cur.node.left!=null)q.add(new Pair(cur.node.left,cur.hd-1));
            if(cur.node.right!=null)q.add(new Pair(cur.node.right,cur.hd+1));
        }

        return new ArrayList<>(map.values());

    }

    static int diameter(Node root){
        if(root==null)return 0;
        int lh =height(root.left);
        int rh =height(root.right);
        int diMiddle =lh+rh;
        int dl =diameter(root.left);
        int dr =diameter(root.right);
        return Math.max(Math.max(dl,dr),diMiddle);
    }
 static int diameter =0;
    static int height(Node root){
        if(root==null)return 0;
        int lh =height(root.left);
        int rh =height(root.right);
        diameter =Math.max(diameter,lh+rh);
        return Math.max(lh,rh)+1;
    }

    static class Pair{
        Node node;
        int hd;

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
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
