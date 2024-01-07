class Solution {
    public List<List<String>> solveNQueens(int n) {
        String[][] ch = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ch[i], ".");
        }

        List<List<String>> answer = new ArrayList<>();
        backtrack(0, n, ch, answer);
        return answer;
    }
    
    private void backtrack(int level, int n, String[][] ch, List<List<String>> answer) {
        if (level == n) {
            List<String> sub = new ArrayList<>();
            for (String[] row : ch) {
                String tmp = "";
                for (String x : row) tmp += x;
                sub.add(tmp);
            }
            answer.add(sub);
            return;
        }

        String queen = "Q";
        for (int i = 0; i < n; i++) {
            if (validate(level, i, n, queen, ch)) {
                ch[level][i] = queen;
                backtrack(level + 1, n, ch, answer);
                ch[level][i] = ".";
            }
        }
    }

    private boolean validate(int x, int y, int n, String queen, String[][] ch) {
        for (int i = 0; i < n; i++) {
            if (ch[x][i].equals(queen)) return false;
            if (ch[i][y].equals(queen)) return false;
        }

        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, 1, -1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (ch[nx][ny].equals(queen)) return false;
                nx += dx[i];
                ny += dy[i];
            }
        }

        return true;
    }
}