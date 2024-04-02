class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] ch = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        ch[0] = 1;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : rooms.get(now)) {
                if (ch[next] == 0) {
                    ch[next] = 1;
                    queue.offer(next);
                }
            }
        }
        
        for (int x : ch) {
            if (x == 0) return false;
        }
        
        return true;
    }
}