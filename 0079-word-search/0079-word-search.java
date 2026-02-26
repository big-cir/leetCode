class Solution {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        char start = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != start) continue;
                if (dfs(i, j, 1, word, board)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int x, int y, int index, String word, char[][] board) {
        if (index == word.length()) return true;

        char temp = board[x][y];
        board[x][y] = '#';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                if (board[nx][ny] == word.charAt(index)) {
                    if (dfs(nx, ny, index + 1, word, board)) {
                        return true;
                    }
                }
            }
        }

        board[x][y] = temp;
        return false;
    }
}