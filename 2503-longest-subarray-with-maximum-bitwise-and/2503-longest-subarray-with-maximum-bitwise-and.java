

// 1을 가장 많이 가지는 수 찾기
// 연속된
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int prev = nums[0];
        int answer = 0;
        int cnt = 0;
        if (prev == max) {
            cnt = 1;
            answer = 1;
        }
        
        for (int i = 1; i < n; i++) {
            if (nums[i] == max) {
                cnt++;
            } else if (nums[i] == max && prev == nums[i]) {
                cnt++;
            } else {
                cnt = 0;
            }

            prev = nums[i];
            answer = Math.max(cnt, answer);
        }
        
        return answer;
    }
}
