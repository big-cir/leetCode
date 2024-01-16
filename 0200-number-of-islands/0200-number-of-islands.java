class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        int answer = 0;
        int[][] ch = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ch[i][j] == 0 && grid[i][j] == '1') {
                    bfs(i, j, grid, ch);
                    answer++;
                }
            }
        }
        return answer;
    }
    
    
    private void bfs(int x, int y, char[][] grid, int[][] ch) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        ch[x][y] = 1;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                    if (ch[nx][ny] == 0 && grid[nx][ny] == '1') {
                    ch[nx][ny] = 1;
                    queue.offer(new int[] {nx, ny});
                    }
                }
            }
            
        }
    }
}