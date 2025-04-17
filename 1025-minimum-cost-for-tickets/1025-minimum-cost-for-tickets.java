class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] ch = new int[366];
        for (int day : days) ch[day] = 1;

        int[] dp = new int[366];
        for (int i = 1; i < dp.length; i++) {
            if (ch[i] == 1) {
                int prevOne = dp[Math.max(0, i - 1)] + costs[0];
                int prevSeven = dp[Math.max(0, i - 7)] + costs[1];
                int prevLast = dp[Math.max(0, i - 30)] + costs[2];
                dp[i] = Math.min(prevLast, Math.min(prevOne, prevSeven));
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[365];
    }
}