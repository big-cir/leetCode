class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    char buffer = board[i][j];
                    board[i][j] = '.';
                    if (backtrack(board, i, j, word, 0)) return true;
                    board[i][j] = buffer;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, int x, int y, String word, int count) {
        if (count + 1 == word.length()) return true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                if (board[nx][ny] == word.charAt(count + 1)) {
                    char buffer = board[nx][ny];
                    board[nx][ny] = '.';
                    if (backtrack(board, nx, ny, word, count + 1)) return true;
                    board[nx][ny] = buffer;
                }
            }
        }
        
        return false;
    }
}