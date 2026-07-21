import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphPracticeQuestions {

    // Scenario 1: Representation using adjacency list + HashSet
    public static Map<Integer, Set<Integer>> buildGraph(List<int[]> edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            graph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }
        return graph;
    }

    public static boolean isFriend(Map<Integer, Set<Integer>> graph, int u, int v) {
        return graph.getOrDefault(u, Collections.emptySet()).contains(v);
    }

    // Scenario 2: BFS shortest path
    public static List<Integer> shortestPath(Map<Integer, List<Integer>> graph, int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);
        parent.put(start, -1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == target) break;

            for (int next : graph.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    parent.put(next, current);
                    queue.offer(next);
                }
            }
        }

        if (!visited.contains(target)) return Collections.emptyList();

        LinkedList<Integer> path = new LinkedList<>();
        int node = target;
        while (node != -1) {
            path.addFirst(node);
            node = parent.get(node);
        }
        return path;
    }

    // Scenario 3: DFS all paths
    public static List<List<Integer>> allPaths(Map<Integer, List<Integer>> graph, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfsAllPaths(graph, start, target, path, visited, result);
        return result;
    }

    private static void dfsAllPaths(Map<Integer, List<Integer>> graph, int current, int target,
                                   List<Integer> path, Set<Integer> visited,
                                   List<List<Integer>> result) {
        path.add(current);
        visited.add(current);

        if (current == target) {
            result.add(new ArrayList<>(path));
        } else {
            for (int next : graph.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    dfsAllPaths(graph, next, target, path, visited, result);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }

    // Scenario 4: Connected components
    public static int countConnectedComponents(Map<Integer, List<Integer>> graph, int n) {
        Set<Integer> visited = new HashSet<>();
        int components = 0;

        for (int node = 0; node < n; node++) {
            if (!visited.contains(node)) {
                components++;
                dfsVisit(graph, node, visited);
            }
        }
        return components;
    }

    private static void dfsVisit(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsVisit(graph, neighbor, visited);
            }
        }
    }

    // Scenario 5: Undirected cycle detection
    public static boolean hasUndirectedCycle(Map<Integer, List<Integer>> graph, int n) {
        Set<Integer> visited = new HashSet<>();
        for (int node = 0; node < n; node++) {
            if (!visited.contains(node) && dfsUndirectedCycle(graph, node, -1, visited)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfsUndirectedCycle(Map<Integer, List<Integer>> graph, int node, int parent, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                if (dfsUndirectedCycle(graph, neighbor, node, visited)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // Scenario 6: Directed cycle detection
    public static boolean hasDirectedCycle(Map<Integer, List<Integer>> graph, int n) {
        int[] state = new int[n]; // 0=unvisited, 1=visiting, 2=done
        for (int node = 0; node < n; node++) {
            if (state[node] == 0 && dfsDirectedCycle(graph, node, state)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfsDirectedCycle(Map<Integer, List<Integer>> graph, int node, int[] state) {
        state[node] = 1;
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (state[neighbor] == 1) return true;
            if (state[neighbor] == 0 && dfsDirectedCycle(graph, neighbor, state)) return true;
        }
        state[node] = 2;
        return false;
    }

    // LeetCode 1971: Find if Path Exists in Graph
    public static boolean validPath(int n, int[][] edges, int start, int end) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return shortestPath(graph, start, end).size() > 0;
    }

    // LeetCode 200: Number of Islands
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfsIsland(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private static void dfsIsland(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != '1') {
            return;
        }
        visited[i][j] = true;
        dfsIsland(grid, i + 1, j, visited);
        dfsIsland(grid, i - 1, j, visited);
        dfsIsland(grid, i, j + 1, visited);
        dfsIsland(grid, i, j - 1, visited);
    }

    // LeetCode 547: Number of Provinces
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfsProvince(isConnected, i, visited);
            }
        }
        return count;
    }

    private static void dfsProvince(int[][] isConnected, int city, boolean[] visited) {
        visited[city] = true;
        for (int next = 0; next < isConnected.length; next++) {
            if (isConnected[city][next] == 1 && !visited[next]) {
                dfsProvince(isConnected, next, visited);
            }
        }
    }

    // LeetCode 1091: Shortest Path in Binary Matrix
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) return -1;
        int n = grid.length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];
                if (r == n - 1 && c == n - 1) return steps + 1;
                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    // LeetCode 797: All Paths From Source to Target
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsSourceTarget(graph, 0, path, result);
        return result;
    }

    private static void dfsSourceTarget(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        path.add(node);
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
        } else {
            for (int neighbor : graph[node]) {
                dfsSourceTarget(graph, neighbor, path, result);
            }
        }
        path.remove(path.size() - 1);
    }

    // LeetCode 841: Keys and Rooms
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfsRooms(rooms, 0, visited);
        for (boolean seen : visited) if (!seen) return false;
        return true;
    }

    private static void dfsRooms(List<List<Integer>> rooms, int room, boolean[] visited) {
        visited[room] = true;
        for (int key : rooms.get(room)) {
            if (!visited[key]) dfsRooms(rooms, key, visited);
        }
    }

    // LeetCode 684: Redundant Connection
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (find(parent, u) == find(parent, v)) return edge;
            union(parent, u, v);
        }
        return new int[]{-1, -1};
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private static void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA != rootB) parent[rootB] = rootA;
    }

    // LeetCode 207: Course Schedule
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int processed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            processed++;
            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }
        return processed == numCourses;
    }

    // LeetCode 210: Course Schedule II
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int[] order = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[idx++] = course;
            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }
        return idx == numCourses ? order : new int[]{};
    }

    // LeetCode 785: Is Graph Bipartite?
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                color[i] = 0;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = color[node] ^ 1;
                            queue.offer(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> routes = new HashMap<>();
        routes.put(0, List.of(1, 2));
        routes.put(1, List.of(3));
        routes.put(2, List.of(3));
        routes.put(3, List.of());

        System.out.println("Shortest path: " + shortestPath(routes, 0, 3));
        System.out.println("All paths: " + allPaths(routes, 0, 3));
        System.out.println("Connected components: " + countConnectedComponents(routes, 4));
        System.out.println("Undirected cycle: " + hasUndirectedCycle(routes, 4));
        System.out.println("Directed cycle: " + hasDirectedCycle(routes, 4));
    }
}
