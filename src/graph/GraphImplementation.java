package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphImplementation {
    private int V;
    private LinkedList<Integer> adj[];
    GraphImplementation(int v){
        this.V = v;
        adj = new LinkedList[V];

        for (int i = 0; i <V ; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v , int w){
        adj[v].add(w);
    }

    void BFS(int s){
        boolean visited[] = new boolean[V];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()){
             s = q.poll();
            System.out.print(s+" ");
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if (!visited[n]){
                    visited[n]=true;
                    q.add(n);
                }
            }
        }

    }

    public static void main(String[] args) {
        GraphImplementation graph = new GraphImplementation(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        graph.BFS(2);

    }
}
