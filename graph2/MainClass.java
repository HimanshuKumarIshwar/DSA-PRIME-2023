package graph2;
import java.util.*;
public class MainClass {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
      int v =8;
      for(int i=0; i<v; i++){
          graph.add(new ArrayList<>());
      }



      addEdge(graph, 0, 1);
      addEdge(graph, 0, 2);
      addEdge(graph, 1, 5);
      addEdge(graph,2,5);
      addEdge(graph, 5, 7);
      addEdge(graph, 7,4);

      addEdge(graph,7, 6);
      addEdge(graph, 6, 3);
      boolean []visit = new boolean[v];
   //dfs(graph,0,visit);
      // dfsIteratively(graph, 0, visit);
        System.out.println(numberOfConnectedComponents(graph,v));

    }


  static void dfs(List<List<Integer>> graph, int cur, boolean []visit){
        visit[cur] = true;
      //System.out.println(cur);
        for(int neighbor: graph.get(cur)){
            if(!visit[neighbor]){
                dfs(graph,neighbor,visit);
            }
        }
  }

static void dfsIteratively(List<List<Integer>> graph, int cur, boolean[] visit){
        ArrayDeque<Integer> stack  = new ArrayDeque<>();
        stack.push(cur);
        visit[cur] = true;
        while(!stack.isEmpty()){
            int a  = stack.pop();

            System.out.println(a);
            for(int neighbor: graph.get(a)){
                if(!visit[neighbor]){
                    stack.push(neighbor);
                    visit[neighbor] = true;
                }
            }
        }
}

  static int numberOfConnectedComponents(List<List<Integer>> graph , int v){
        boolean visit[] =new boolean[v];
        int count =0;
        for(int i=0; i<v; i++){
            if(!visit[i]){
                count++;
                dfs(graph, i, visit);
            }
        }
        return count;
  }




    static void addEdge(List<List<Integer>> graph,int a, int b){
           if(graph.get(a).contains(b))return;

             graph.get(a).add(b);
             graph.get(b).add(a);
    }




}
