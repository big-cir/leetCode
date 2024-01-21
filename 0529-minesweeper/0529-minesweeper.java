class Solution {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        bfs(click[0], click[1], board);
        return board;
    }
    
    private void bfs(int clickX, int clickY, char[][] board) {
        int[][] ch = new int[board.length][board[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {clickX, clickY});
        ch[clickX][clickY] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int mineCnt = findMines(now[0], now[1], board);

            if (mineCnt == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        queue.offer(new int[] {nx, ny});
                    }
                }

                board[now[0]][now[1]] = 'B';
            } else {
                board[now[0]][now[1]] = (char) (mineCnt + '0');
            }
        }
    }

    private int findMines(int x, int y, char[][] board) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                if (board[nx][ny] == 'M') cnt++;
            }
        }
        return cnt;
    }
}