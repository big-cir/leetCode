class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        // {amount, count}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {amount, 0});
        int[] visit = new int[amount + 1];
        visit[amount] = 1;
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int coin : coins) {
                if (poll[0] >= coin) {
                    int tmp = poll[0] - coin;
                    if (tmp == 0) return poll[1] + 1;
                    
                    if (visit[tmp] == 0) {
                        visit[tmp] = 1;
                        queue.offer(new int[] {tmp, poll[1] + 1});
                    }
                }
            }
        }
        return -1;
    }
}