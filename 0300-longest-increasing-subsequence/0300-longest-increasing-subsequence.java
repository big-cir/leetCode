class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[1] = 1;
        
        for (int i = 2; i < dp.length; i++) {
            int num = nums[i - 1];
            for (int j = i - 1; j >= 1; j--) {
                if (num > nums[j - 1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}