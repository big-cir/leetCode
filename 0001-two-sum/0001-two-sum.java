class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                map.put(sum, new int[] {i, j});
            }
        }
        return map.get(target);
    }
}