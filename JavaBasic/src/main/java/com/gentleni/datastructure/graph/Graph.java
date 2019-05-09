package com.gentleni.datastructure.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by GentleNi
 * Date 2019/1/24.
 */
public class Graph {
    private int v;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v;i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.println(s + " ");
            Iterator<Integer> iterator = adj[s].iterator();

            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

    }

    void DFSTraverse (int v) {
        boolean[] visited = new boolean[v];
        DFS(v,visited);


    }

    void DFS(int v,boolean[] visited) {

    }

    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        g.BFS(2);
    }
}
