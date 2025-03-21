class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int answer = 1;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (nums[i] == nums[i - 1]) continue;
                answer = Math.max(answer, length);
                length = 1;
            } else {
                length++;
            }
        }

        return Math.max(answer, length);
    }
}