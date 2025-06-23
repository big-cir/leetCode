class Solution {

    static int n, m;

    public boolean hasValidPath(int[][] grid) {
        // {in, out}
        int[][] rules = {
            {0, 0, 0, 0}, 
            {0, -1, 0, 1}, {-1, 0, 1, 0}, {0, -1, 1, 0},
            {1, 0, 0, 1}, {0, -1, -1, 0}, {-1, 0, 0, 1}
        };

        n = grid.length;
        m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        int[][] ch = new int[n][m];
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];
            ch[x][y] = 1;

            if (x == n - 1 && y == m - 1) return true;
            int g = grid[x][y];
            int[] rule = rules[g];

            int idx = 0;
            for (int i = 0; i < 2; i++) {
                int nx = x + rule[idx];
                int ny = y + rule[idx + 1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int ng = grid[nx][ny];
                    int[] ngRule = rules[ng];

                    int idx2 = 0;
                    for (int j = 0; j < 2; j++) {
                        int ngx = ngRule[idx2], ngy = ngRule[idx2 + 1];
                        if ((ngx + rule[idx] == 0) && (ngy + rule[idx + 1] == 0)) {
                            if (ch[nx][ny] == 0) queue.offer(new int[] {nx, ny});
                        }

                        idx2 += 2;
                    }
                }

                idx += 2;
            }

        }

        return false;
    }
}

// 1: 왼오
// 2: 위아래
// 3: 왼아래