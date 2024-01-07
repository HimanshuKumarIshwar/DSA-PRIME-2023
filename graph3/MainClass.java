package graph3;
import java.util.*;
public class MainClass {
    public static void main(String[] args) {
       ArrayList<ArrayList<Integer>>  graph = new ArrayList<>();

       int v =6;
       for(int i = 0; i < v; i++){
           graph.add(new ArrayList<>());
       }

       addEdge(graph, 5, 0);
       addEdge(graph, 4, 0);
       addEdge(graph, 5, 2);
       addEdge(graph, 2, 3);
       addEdge(graph, 3, 1);
       addEdge(graph, 4, 1);

//topologicalOrder(graph, v);
        topologicalOrderKahnAlgo(graph, v);


    }

    static void topologicalOrderKahnAlgo(ArrayList<ArrayList<Integer>>  graph, int v){
        Queue<Integer> q = new LinkedList<>();
       
        int []indegree = new int[v];
        for(int i=0; i<v; i++){
            for(int e: graph.get(i)){
                indegree[e]++;
            }
        }

        for(int i=0; i<v; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur =q.poll();
           
            System.out.println(cur);

          for(int e: graph.get(cur)){
              
              indegree[e]--;
              if(indegree[e]==0){
                  q.add(e);
                 
              }
          }

        }




    }
    static void topologicalOrder(ArrayList<ArrayList<Integer>>  graph, int v){
        boolean visit[] = new boolean[v];
        ArrayDeque<Integer> stackAns = new ArrayDeque<>();
        for(int i=0; i<v; i++){
            if (!visit[i]) {
                dfs(graph, visit, i, stackAns);
            }
        }
        while(!stackAns.isEmpty()){
            System.out.println( stackAns.pop());
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>>  graph, boolean visit[],int cur, ArrayDeque<Integer> ansStack){
        visit[cur] =true;
        for(int neighbours: graph.get(cur)){
            if(!visit[neighbours]){
                dfs(graph,visit, neighbours, ansStack );
            }
        }
        ansStack.push(cur);
    }

    static void addEdge(ArrayList<ArrayList<Integer>>  graph, int a, int b){
        if(graph.get(a).contains(b))return;
            graph.get(a).add(b);

    }
}
