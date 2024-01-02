class Solution {
    static boolean answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public boolean exist(char[][] board, String word) {
        answer = false;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] ch = new int[board.length][board[0].length];
                    ch[i][j] = 1;
                    dfs(board, word, i, j, 1, ch);
                }
                
                if (answer) break;
            }
        }
        return answer;
    }
    
    private void dfs(char[][] board, String word, int x, int y, int idx, int[][] ch) {
        if (idx == word.length()) {
            answer = true;
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                if (board[nx][ny] == word.charAt(idx) && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    dfs(board, word, nx, ny, idx + 1, ch);
                    ch[nx][ny] = 0;
                }
            }
        }
    }
}