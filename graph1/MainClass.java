package graph1;
import java.util.*;
public class MainClass {
    public static void main(String[] args) {
     ArrayList<ArrayList<Integer>> graph = new ArrayList<>();



        int v =4;
        // using adjacency List
        for(int i=0; i<v; i++){
            graph.add(new ArrayList<>());
        }
        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 2);



        // using Adjancey Matrix
         int [][]graphMat =new int[v][v];
//       addEdgeMat(graphMat, 0, 1,3);
//       addEdgeMat(graphMat,0,  2, 8);
//       addEdgeMat(graphMat, 0, 3, 1);
//       addEdgeMat(graphMat,1 , 2, 5);
//       addEdgeMat(graphMat, 3, 2, 3);

//   boolean[] visit =new boolean[v];
//   int dist[]= new int[v];
//   int prec[] = new int[v];
//   int src =0;

//   bfs(graph,src,visit,dist, prec);
//   for(int i=0; i<v; i++){
//       System.out.println(i+ " ->" + dist[i]);
//   }
//
   }
    static void findPath(ArrayList<ArrayList<Integer>> graph, int src, int dest){
             int v =4;
            boolean[] visit =new boolean[v];
            int dist[]= new int[v];
            int prec[] = new int[v];

            bfs(graph,src,visit,dist, prec);
     while(dest !=-1){
         System.out.println(dest);
          dest =prec[dest];
     }


    }
    static void bfs(ArrayList<ArrayList<Integer>> graph, int src, boolean []visit, int[] dist,int[] prec){
          Queue<Integer> q =new LinkedList<>();

          q.add(src);
          visit[src] = true;
          prec[src] = -1;
        dist[src] = 0;
          while(!q.isEmpty()){
               int cur =q.poll();
              System.out.println(cur);
              for(int neighbours: graph.get(cur)){
                  if(!visit[neighbours]){
                      q.add(neighbours);
                      visit[neighbours] = true;
                      dist[neighbours] = dist[cur]+1;
                      prec[neighbours] = cur;
                  }
              }
          }
    }


    static void addEdge( ArrayList<ArrayList<Integer>> graph, int a, int b){
       if(graph.get(a).contains(b))return;
       graph.get(a).add(b);
       graph.get(b).add(a);

    }
    static void addEdgeMat(int graphMat[][], int src, int dest, int wt){
        graphMat[src][dest] = wt;
    }
}
