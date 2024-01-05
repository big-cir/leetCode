class Solution {

    public void solveSudoku(char[][] board) {
        char[][] cache = new char[board.length][board[0].length];
        backtrack(0, 0, board, cache);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]= cache[i][j];
            }
        }
    }
    
    private void backtrack(int x, int y, char[][] board, char[][] cache) {
        // column에 값을 다 집어넣으면 다음 row 탐색
        if (y == board[0].length) {
            backtrack(x + 1, 0, board, cache);
            return;
        }
        
				// 마지막 x행까지 채워지면 호출을 종료합니다.
        if (x == board.length) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    cache[i][j] = board[i][j];
                }
            }
            return;
        }
        
        if (board[x][y] == '.') {
            for (int i = 1; i <= 9; i++) {
                char currentValue = (char) (i + '0');
                if (checkAll(x, y, currentValue, board)) {
                    board[x][y] = currentValue;
                    backtrack(x, y + 1, board, cache);
                }
            }
            
            // 위에서 재귀를 탐색하다가, 유효성 검사를 통과하지 못하면 이전 단계로 복구
            board[x][y] = '.';
            return;
        }
        
        // 이전 단계로 복구 후 다시 현재 위치부터 탐색을 시작한다.
        backtrack(x, y + 1, board, cache);
    }
    
    private boolean checkAll(int x, int y, char currentValue, char[][] board) {
        // 같은 row 중복 값 검사
        for (int i = 0; i < board[0].length; i++) {
            if (board[x][i] == currentValue) return false;
        }
        
        // 같은 column 중복 검사
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == currentValue) return false;
        }
        
        // 3 * 3 gird 검사
        int size = (int) Math.sqrt(board.length);
        int rangeX = (x / size) * size;
        int rangeY = (y / size) * size;
        for (int i = rangeX; i < rangeX + size; i++) {
            for (int j = rangeY; j < rangeY + size; j++) {
                if (board[i][j] == currentValue) return false;
            }
        }
        return true;
    }
}