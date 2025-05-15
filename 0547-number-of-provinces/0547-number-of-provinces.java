class Solution {
    public int findCircleNum(int[][] isConnected) {
        int answer = 0;
        int n = isConnected.length;
        int m = isConnected[0].length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int[] con = isConnected[i];
            for (int j = 0; j < m; j++) {
                if (i == j) continue;
                if (con[j] == 1) graph.get(i + 1).add(j + 1);
            }
        }

        int[] ch = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0) {
                dfs(i, ch, graph);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int node, int[] ch, List<List<Integer>> graph) {
        ch[node] = 1;

        for (int next : graph.get(node)) {
            if (ch[next] == 0) {
                dfs(next, ch, graph);
            }
        }
    }
}