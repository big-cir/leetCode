class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(nums[i - 1], dp[i - 1] + nums[i - 1]);
            answer = Math.max(answer, dp[i]);
        }
        
        return answer;
    }
}