class Solution {
    public int subarraySum(int[] nums, int k) {
        int answer = 0;
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                if (dp[j] - dp[i] == k) answer++;
            }
        }

        return answer;
    }
}