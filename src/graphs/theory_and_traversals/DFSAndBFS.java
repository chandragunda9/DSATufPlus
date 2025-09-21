package graphs.theory_and_traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSAndBFS {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, res);
            }
        }
        return res;
    }

    static void dfs(int u, boolean[] vis, List<List<Integer>> adj, List<Integer> res) {
        vis[u] = true;
        res.add(u);
        List<Integer> conn = adj.get(u);
        for (int v : conn) {
            if (!vis[v]) {
                dfs(v, vis, adj, res);
            }
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                bfs(i, adj, vis, res);
            }
        }
        return res;
    }

    static void bfs(int V, List<List<Integer>> adj, boolean[] vis, List<Integer> res) {
        Queue<Integer> q = new LinkedList<>();

        int start = 0;
        q.add(start);
        vis[start] = true;
        while (!q.isEmpty()) {
            Integer u = q.poll();
            res.add(u);
            List<Integer> conn = adj.get(u);
            for (int v : conn) {
                if (!vis[v]) {
                    q.add(v);
                    vis[v] = true;
                }
            }
        }
    }
}
