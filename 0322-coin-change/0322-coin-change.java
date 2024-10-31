class Solution {
    public int coinChange(int[] coins, int amount) {
        int answer = bfs(coins, amount);
        
        if (amount == 0) return 0;
        return answer == 10001 ? -1 : answer;
    }
    
    private static int bfs(int[] coins, int amount) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            queue.offer(coin);
            map.put(coin, 1);
        }
        
        int max = 10001;
        int answer = 10001;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            if (now > max) continue;
            
            if (now == amount) {
                answer = Math.min(answer, map.get(now));
            }
            
            for (int coin : coins) {
                if (now > amount - coin) continue;
                
                int nv = now + coin;
                int nc = map.get(now) + 1;
                
                if (nv > max) continue;
                if (map.containsKey(nv) && map.get(nv) <= nc) continue;
                
                queue.offer(nv);
                map.put(nv, nc);
            }
        }
        
        return answer;
    }
}