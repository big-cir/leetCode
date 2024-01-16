class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        int answer = 0;
        int[][] ch = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ch[i][j] == 0 && grid[i][j] == '1') {
                    dfs(i, j, grid, ch);
                    answer++;
                }
            }
        }
        return answer;
    }
    
    private void dfs(int x, int y, char[][] grid, int[][] ch) {
        ch[x][y] = 1;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                if (ch[nx][ny] == 0 && grid[nx][ny] == '1') {
                    ch[nx][ny] = 1;
                    dfs(nx, ny, grid, ch);
                }
            }
        }
    }
}