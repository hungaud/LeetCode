import java.util.*;

public class CriticalRouter {

    private static HashSet<Integer> result = new HashSet<>();
    private static HashSet<Integer> visted = new HashSet<>();

    public static void main(String[] args) {
        int numNodes = 9;
        int numEdges = 10;
        int[][] edges = new int[][] {
               // {0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}
                //{1, 2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}
                //{1, 2}, {1, 3}, {2, 3}, {2, 4}, {2, 5}, {4, 6}, {5, 6}
                {1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9}


        };
        int[] arr = criticalNodes(numNodes, numEdges, edges);
        for(int n : result) {
            System.out.println(n);
        }
    }

    private static int[] criticalNodes(int numNodes, int numEdges, int[][] edges) {
        int[] res = new int[numNodes];
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numEdges; i++) {
            int node = edges[i][0];
            int edge = edges[i][1];
            if(!graph.containsKey(node)) {
                graph.put(node, new HashSet<>());
            }
            if(!graph.containsKey(edge)) {
                graph.put(edge, new HashSet<>());
            }
            graph.get(node).add(edge);
            graph.get(edge).add(node);
        }

        // ban each node
        for(int n : graph.keySet()) {
            dfs(graph, numNodes, n);
        }

        // too lazy to change method signature to ArrayList<> just return dummy arr here b/c its late af

        return res;
    }

    // this will check if ban nodes will break the graph.
    // when visted isnt same as one less size of nodes. add the ban.
    // if it is the same. means all other nodes were able to hit. so just return
    private static void dfs(HashMap<Integer, HashSet<Integer>> graph, int numNodes, int ban) {
        for(int key : graph.keySet()){
            if(key == ban) continue;
            dfsHelper(graph, numNodes, ban, key);
            if(visted.size() != numNodes - 1) {
                result.add(ban);
            } else if(visted.size() == numNodes - 1) {
                visted.clear();
                return;
            }
            visted.clear();
        }
    }

    // dfs - tries to visit each node .
    private static void dfsHelper(HashMap<Integer, HashSet<Integer>> graph, int numNodes, int ban, int node) {
        if (node != ban && !visted.contains(node)) {
            visted.add(node);
            for(int edge : graph.get(node)) {
                dfsHelper(graph, numNodes, ban, edge);
            }
        }
    }
}
