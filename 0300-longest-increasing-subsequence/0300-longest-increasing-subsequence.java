class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        for (int i = 1; i < dp.length; i++) {
            int fix = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (fix > nums[j]) dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i]++;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}