class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int newTarget = target - value;
            
            if (map.containsKey(newTarget)) {
                return new int[] {map.get(newTarget), i};
            } else {
                map.put(value, i);
            }
        }
        
        return new int[] {-1, -1};
    }
}