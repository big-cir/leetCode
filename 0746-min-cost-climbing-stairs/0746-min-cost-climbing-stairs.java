class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int top = cost.length + 1;
        int[] dp = new int[top + 1];
        dp[1] = cost[0];
        dp[2] = cost[1];

        if (top >= 3) {
            for (int i = 3; i < top; i++) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i - 1];
            }
            dp[top] = Math.min(dp[top - 1], dp[top - 2]);
        }

        return dp[top];
    }
}