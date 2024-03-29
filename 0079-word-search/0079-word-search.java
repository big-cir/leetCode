class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean answer;
    
    public boolean exist(char[][] board, String word) {
        answer = false;
        int n = board.length;
        int m = board[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] ch = new int[n][m];
                    ch[i][j] = 1;
                    dfs(1, board, ch, i, j, word);
                }
                
                if (answer) return answer;
            }
        }
        return answer;
    }
    
    public void dfs(int level, char[][] board, int[][] ch, int x, int y, String s) {
        if (level == s.length()) {
            answer = true;
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && ch[nx][ny] == 0) {
                if (board[nx][ny] == s.charAt(level)) {
                    ch[nx][ny] = 1;
                    dfs(level + 1, board, ch, nx, ny, s);
                    ch[nx][ny] = 0;
                }
            }
        }
    }
}