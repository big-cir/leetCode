class Solution {
    
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public int shortestPathBinaryMatrix(int[][] grid) {        
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        bfs(0, 0, grid, n);
        
        return grid[n - 1][n - 1] == 0 ? -1 : grid[n - 1][n - 1];
    }
    
    
    private void bfs(int x, int y, int[][] grid, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        grid[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                    grid[nx][ny] = grid[now[0]][now[1]] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
// 0 0 0 0 1
// 1 0 0 0 0
// 0 1 0 1 0
// 0 0 0 1 1
// 0 0 0 1 0

// 0 0 0
// 1 1 0
// 1 1 1