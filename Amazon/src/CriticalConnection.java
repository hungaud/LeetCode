import java.util.*;

public class CriticalConnection {

    static int count = 0;

    public static void main(String[] args) {
        int numNodes = 9;
        int numEdges = 10;
        int[][] edges = new int[][]{
                // {0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}
                //{1, 2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}
                //{1, 2}, {1, 3}, {2, 3}, {2, 4}, {2, 5}, {4, 6}, {5, 6}
                //{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9}
                //{0, 1}, {1, 2}, {2, 0}, {1, 3}
                {0, 1}, {1, 2}, {2, 0}, {2, 5}, {5, 0}
                 //{0,1}, {1,2}, {1,3}, {2,3}

        };
        int n = 6;

        List<List<Integer>> list = new ArrayList<>();
        for (int[] e : edges) {
            list.add(new ArrayList<Integer>() {{
                add(e[0]);
                add(e[1]);
            }});
        }

        List<List<Integer>> r = criticalConnections(n, list);
        for (List<Integer> bans : r) {
            System.out.println(bans.toString());
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] low = new int[n];
        int[] visted = new int[n];
        int[] parents = new int[n];
        Arrays.fill(low, -1);
        Arrays.fill(visted, -1);
        Arrays.fill(parents, -1);
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();


        for(int i = 0; i < connections.size(); i++) {
            int a = connections.get(i).get(0);
            int b = connections.get(i).get(1);
            if(graph[a] == null) {
                graph[a] = new ArrayList<>();
            }
            if(graph[b] == null) {
                graph[b] = new ArrayList<>();
            }
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0; i < n; i++) {
            if(visted[i] == -1) {
                dfs(i, parents, visted, low, graph, res);
            }
        }

        count = 0;
        return res;
    }

    // what we're doing here is marking each node, the lowest node that can reach the current node.
    //
    private static void dfs(int current, int[] parents, int[] visited, int[] low, List<Integer>[] graph, List<List<Integer>> res) {
        if(visited[current] != -1 || graph[current] == null)
            return;
        low[current] = count;
        visited[current] = count;
        count++;

        // get current's neighbors
        for(int dest : graph[current]) {
            // if neighbor is unvisited
            if(visited[dest] == -1) {
                parents[dest] = current;
                dfs(dest, parents, visited, low, graph, res);
                // gets the lowest between lowest current and the low from it's destination (after getting the lowest from its dest)
                low[current] = Math.min(low[current], low[dest]);
                if(low[dest] > visited[current]) {
                    // this adds it b/c low dest is higher than current discover/rank. which means dest low was never updated to the same low
                    // as a node before the current node.
                    res.add(Arrays.asList(current, dest));
                }
            } else if (parents[current] != dest) {
                // destination isnt parent so it checks the destination value vs the current lowest.
                low[current] = Math.min(low[current], visited[dest]);
            }
        }
    }
}
// from node 1 - 3, it cant get 1's low because 1 is its parents so it looks for other connnecting nodes. b/c no other connecting node
// connects back to 0 or 2, its low is still at 3. while 1, 2, and 0 lows are all 0.

/*
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < connections.size(); i++) {
            int a = connections.get(i).get(0);
            int b = connections.get(i).get(1);
            if(!map.containsKey(a)) {
                map.put(a, new HashSet<>());
            }
            if(!map.containsKey(b)) {
                map.put(b, new HashSet<>());
            }
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int current = 0;
        for(int key : map.keySet()) {
            dfs(map, n, key, connections.get(current));
            if(visted.size() != n) {
                result.add(connections.get(current));
            }
            visted.clear();
            current++;
        }
        List<List<Integer>> list = new ArrayList<>();
        list.addAll(result);
        return list;
    }

    private static void dfs(HashMap<Integer, HashSet<Integer>> graph, int n, int startKey, List<Integer> banEdge) {
        int ban1 = banEdge.get(0);
        int ban2 = banEdge.get(1);

        for(int edge : graph.get(startKey)) {
            if((ban1 == edge || ban2 == edge) && (ban1 == startKey || ban2 == startKey)) continue;
            if(!visted.contains(edge)) {
                visted.add(edge);
                dfs(graph, n, edge, banEdge);
            }
        }
    }
}
*/