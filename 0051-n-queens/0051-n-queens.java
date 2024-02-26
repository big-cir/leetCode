class Solution {
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, 1, -1};
    static int[][] map;
    
    public List<List<String>> solveNQueens(int n) {
        map = new int[n][n];
        List<List<String>> answer = new ArrayList<>();
        int[][] ch = new int[n][n];
        backtrack(0, n, ch, answer);
        return answer;    
    }
    
    private void backtrack(int cnt, int n, int[][] ch, List<List<String>> answer) {
        if (cnt == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String tmp = "";
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 0) tmp += ".";
                    else tmp += "Q";
                }
                list.add(tmp);
            }
            answer.add(list);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (check(n, cnt, i)) {
                map[cnt][i] = 1;
                backtrack(cnt + 1, n, ch, answer);
                map[cnt][i] = 0;
            }
        }
    }
    
    private boolean check(int n, int x, int y) {
        for (int i = 0; i < n; i++) {
            if (map[x][i] == 1) return false;
            if (map[i][y] == 1) return false;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (map[nx][ny] == 1) return false;
                nx += dx[i];
                ny += dy[i];
            }
        }
        
        return true;
    }
}