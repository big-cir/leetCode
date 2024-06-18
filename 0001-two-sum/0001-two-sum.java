class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int gap = target - nums[i];

            if (store.containsKey(gap)) {
                return new int[] {store.get(gap), i};
            }

            // 현재 값과 index를 저장
            store.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}