class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] tmp = nums.clone();
        int[] values = new int[2];

        Arrays.sort(tmp);
        int lt = 0;
        int rt = tmp.length - 1;

        while (lt < rt) {
            int sum = tmp[lt] + tmp[rt];

            if (sum <= target) {
                if (sum == target) {
                    values[0] = tmp[lt];
                    values[1] = tmp[rt];
                }
                lt++;
            } else {
                rt--;
            }
        }

        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == values[0]) {
                idx1 = i;
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == values[1] && idx1 != i) {
                idx2 = i;
            }
        }
        return new int[] {idx1, idx2};
    }
}