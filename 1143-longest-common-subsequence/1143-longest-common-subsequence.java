class Solution {
    // 두 개의 포인터를 사용해서 dp 테이블을 설계
    public int longestCommonSubsequence(String text1, String text2) {
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        for (int i = 1; i < dp.length; i++) {
            char fix = ch1[i - 1];
            for (int j = 1; j < dp[0].length; j++) {
                if (fix == ch2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
    }
}