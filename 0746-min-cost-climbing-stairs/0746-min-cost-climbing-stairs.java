class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int t = cost.length + 1;
        int[] dp = new int[t + 1];
        dp[1] = cost[0];
        dp[2] = cost[1];

        if (t >= 3) {
            for (int i = 3; i < t; i++) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i - 1];
            }
            dp[t] = Math.min(dp[t - 1], dp[t - 2]);
        }
        return dp[t];
    }
}