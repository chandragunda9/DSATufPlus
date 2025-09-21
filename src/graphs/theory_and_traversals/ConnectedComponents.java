package graphs.theory_and_traversals;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {

    public int findNumberOfComponent(int V, List<List<Integer>> edges) {

        List<List<Integer>> adj = buildAdjList(V, edges);
        int count = 0;
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int u, boolean[] vis, List<List<Integer>> adj) {
        vis[u] = true;
        List<Integer> al = adj.get(u);
        for (int v : al) {
            if (!vis[v]) {
                dfs(v, vis, adj);
            }
        }
    }

    List<List<Integer>> buildAdjList(int n, List<List<Integer>> edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        edges.forEach(edge -> {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        });
        return adjList;
    }
}
