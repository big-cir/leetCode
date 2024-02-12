class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        int answer = 1;
        int cnt = 1;
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                if (nums[i - 1] == nums[i]) continue;
                answer = Math.max(answer, cnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        answer = Math.max(answer, cnt);
        return answer;
    }
}