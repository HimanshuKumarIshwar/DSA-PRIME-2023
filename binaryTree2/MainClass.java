
package binaryTree2;
import java.util.*;
public class MainClass {
    public static void main(String[] args) {
         Node n1 =new Node(1);
         Node n2 =new Node(2);
         Node n3 =new Node(4);
         Node n4 =new Node(3);
         Node n5 =new Node(5);

          Node root =n1;
          n1.left =n2;
          n2.right =n3;
          n1.right =n4;
          n4.right =n5;
          int x=4;
          int y =5;
       // System.out.println(isCousins(root,x,y));


//ArrayList<Integer> ans =new ArrayList<Integer>();
//     nodeAtLevelK(root,1,ans);
//        for (Integer an : ans) {
//            System.out.print(an + " ");
//        }

        ArrayList<Integer> ans =new ArrayList<Integer>();
        ans =nodeAtKLevel(root,0);
        System.out.println(ans);



    }


    static void nodeAtLevelK(Node root, int level, ArrayList<Integer> ans){
        if(root==null || level<0)return;

        if(level==0){
            ans.add(root.val);
            return;
        }

        nodeAtLevelK(root.left,level-1,ans);
        nodeAtLevelK(root.right,level-1,ans);

    }


    static class Pair{
        Node node;
        int level;

        public Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static ArrayList<Integer> nodeAtKLevel(Node root, int level){
        ArrayList<Integer> ans =new ArrayList<>();
        ArrayDeque<Pair> stack =new ArrayDeque<>();
         Pair first =new Pair(root,level);
         stack.push(first);

         while(!stack.isEmpty()){
             Pair cur =stack.poll();
             if(cur.node==null)continue;
             if(cur.level==0){
                 ans.add(cur.node.val);
                 continue;
             }
             stack.push(new Pair(cur.node.right,cur.level-1));
             stack.push(new Pair(cur.node.left,cur.level-1));
         }





        return ans;

    }



    static Node xPar,yPar;
    static int xLevel,yLevel;

    static boolean isCousins(Node root, int x, int y){
          isCousinsHelper(root,null,x,y,0);
          boolean isSameLevel =xLevel==yLevel;
          boolean isNotSameParent = xPar!=yPar;

        return isSameLevel && isNotSameParent;
    }

    static void isCousinsHelper(Node node, Node par, int x,int y, int level){
         if(node==null)return;
         if(x==node.val){
        xPar =par;
          xLevel =level;
         }
         if(y==node.val) {
             yPar = par;
             yLevel = level;
         }


         isCousinsHelper(node.left,node,x,y,level+1);
         isCousinsHelper(node.right,node,x,y,level+1);


    }


}

class Node{
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}
