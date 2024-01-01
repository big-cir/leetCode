class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        back_tracking(0, 0, new int[] {-1, -1}, answer, nums, target);
        return answer;
    }
    
    private void back_tracking(int level, int startIdx, int[] tmp, int[] answer, int[] nums, int target) {
        if (level == 2) {
            if (nums[tmp[0]] + nums[tmp[1]] == target) {
                answer[0] = tmp[0];
                answer[1] = tmp[1];
            }
            return;
        }
        
        for (int i = startIdx; i < nums.length; i++) {
            tmp[level] = i;
            back_tracking(level + 1, i + 1, tmp, answer, nums, target);
            tmp[level] = -1;
        }
    }
}