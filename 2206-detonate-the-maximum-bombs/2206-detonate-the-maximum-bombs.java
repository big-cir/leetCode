class Solution {
    public int maximumDetonation(int[][] bombs) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < bombs.length; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < bombs.length; i++) {
            int[] fix = bombs[i];
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) continue;
                int[] next = bombs[j];

                if (isRange(fix[0], fix[1], next[0], next[1], fix[2])) {
                    graph.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < bombs.length; i++) {
            int[] visit = new int[bombs.length];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            
            int cnt = 0;
            visit[i] = 1;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                cnt++;

                for (int next : graph.get(current)) {
                    if (visit[next] == 0) {
                        visit[next] = 1;
                        queue.offer(next);
                    }
                }
            }

            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    private boolean isRange(int fx, int fy, int x, int y, int radius) {
        long dx = (long) fx - x;
        long dy = (long) fy - y;
        long dis = (long) dx * dx + dy * dy;
        return dis <= (long) radius * radius;
    }
}