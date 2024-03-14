class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visit = new int[rooms.size()];
        visit[0] = 1;
        
        Queue<Integer> queue = new LinkedList<>();
        for (int x : rooms.get(0)) queue.offer(x);
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visit[now] = 1;
            for (int next : rooms.get(now)) {
                if (visit[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        for (int x : visit) {
            if (x == 0) return false;
        }
        
        return true;
    }
}