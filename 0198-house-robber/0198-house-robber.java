class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        if (nums.length >= 2) {
            dp[1] = nums[1];
        }
        
        for (int i = 2; i < nums.length; i++) {
            for (int j = i - 2; j >= 0; j--) {
                dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += nums[i];
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}