class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!bfs(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
        
    }
    
    private boolean bfs(int[][] graph, int vertex, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        color[vertex] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (color[next] == 0) {
                    if (color[now] == 1) {
                        color[next] = -1;
                    }

                    if (color[now] == -1) {
                        color[next] = 1;
                    }

                    queue.offer(next);
                } else if (color[next] == color[now]) {
                    return false;
                }
            }
        }
        return true;
    }
}