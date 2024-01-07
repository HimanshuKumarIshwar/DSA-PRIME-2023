package graph4;

import java.util.ArrayList;
import java.util.Collections;

public class MainClass {
    public static void main(String[] args){
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        int v =6;
        for(int i=0; i<v; i++){
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 4, 1);
        addEdge(graph, 0, 5, 9);
        addEdge(graph, 0, 1, 2);
        addEdge(graph, 1, 2, 8);
        addEdge(graph, 1, 3, 2);
        addEdge(graph, 1, 4, 4);
        addEdge(graph, 1, 5, 5);
        addEdge(graph, 4, 3, 4);
        addEdge(graph, 3, 2, 3);
        addEdge(graph, 5, 4, 3);
        addEdge(graph, 5, 4, 3);

        System.out.println(mstKruskal(graph));


    }

    static int mstKruskal(ArrayList<ArrayList<Pair>> graph){
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i =0; i< graph.size(); i++){
            ArrayList<Pair> adj = graph.get(i);
            for(Pair p: adj){
                edges.add(new Edge(i, p.v, p.wt));
            }
        }

        Collections.sort(edges);
        int v =graph.size();
        DisjointSet ds = new DisjointSet(v);
        int ans =0;
        int count =0;
        for(Edge cur: edges){
            int src = cur.src;
            int dest = cur.dest;


            int findSrc = ds.find(src);
            int findDest = ds.find(dest);
            if(findSrc != findDest){
                ans += cur.wt;
                count++;
                if(count == v-1)break;
                ds.union(src, dest);
            }

        }


return ans;

    }
    static class Edge implements Comparable<Edge>{
        int src, dest, wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt =  wt;
        }

        @Override
        public int compareTo(Edge that) {
            return this.wt-that.wt;
        }
    }




    static void addEdge(ArrayList<ArrayList<Pair>> graph, int src, int dest, int wt){
        graph.get(src).add(new Pair(dest, wt));
        graph.get(dest).add(new Pair(src, wt));
    }
}

class Pair{
    int v;
    int wt;
    public Pair(int v, int wt){
        this.v =v;
        this.wt =wt;

    }
}

class DisjointSet{
    int p[];
    int r[];
    int n;
    int count;

    public DisjointSet(int n){
        this.n = n;
        p =new int[n];
        r = new int[n];
        count = n;
        for(int i =0; i<n; i++){
            p[i] =i;
            r[i] =1;
        }

    }

    public int find(int a){
        if(p[a] != a){
            int root = find(p[a]);
            p[a] = root; // Path Compression
            return root;
        }
        return a;
    }
    public void union(int a, int b){
        int ra = find(a);
        int rb = find(b);
        if(ra != rb){
            count--;
            if(r[ra]> r[rb]){
                p[rb] = ra;
            }else if(r[ra] < r[rb]){
                p[ra] = rb;
            }else {
                p[ra] = rb;
                r[rb]++;
            }
        }

    }


}
