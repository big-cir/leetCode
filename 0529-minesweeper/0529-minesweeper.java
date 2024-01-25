class Solution {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        return bfs(board, click);
    }
    
    private char[][] bfs(char[][] board, int[] click) {
        int[][] ch = new int[board.length][board[0].length];
        Queue<int[]> queue = new LinkedList<>();
        ch[click[0]][click[1]] = 1;
        queue.offer(click);
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            if (board[now[0]][now[1]] == 'M') {
                board[now[0]][now[1]] = 'X';
                return board;
            }   
            
            int mines = calculateMines(board, now);
            
            if (mines != 0) {
                board[now[0]][now[1]] = (char) (mines + '0');
            } else {
                board[now[0]][now[1]] = 'B';
                for (int i = 0; i < 8; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 'E' && ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        queue.offer(new int[] {nx, ny});
                    }
                 }   
            }
        }
        return board;
    }
    
    private int calculateMines(char[][] board, int[] click) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = click[0] + dx[i];
            int ny = click[1] + dy[i];
            
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 'M') {
                 count++;
            }
        }
        return count;
    }
}