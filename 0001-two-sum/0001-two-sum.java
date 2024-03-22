class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        // index, value
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];
            
            if (map.containsKey(gap)) {
                answer[0] = map.get(gap);
                answer[1] = i;
                return answer;
            } else {
                map.put(nums[i], i);
            }
        }
        return answer;
    }
}