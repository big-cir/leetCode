class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        // money를 coin으로 만들 수 있는지 확인
        for (int money = 1; money <= amount; money++) {
            for (int coin : coins) {

                // money가 coin보다 작으면 만들 수 없다.
                if (money >= coin) {
                    // dp[money - coin]
                    // dp[2]일 경우, dp[2 - 1]--> 1원을 사용하고 1원이 남는데, 1원을 만들 수 있는 경우의 수
                    dp[money] = Math.min(dp[money], dp[money - coin] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] == 10001 ? -1 : dp[amount];
    }
}