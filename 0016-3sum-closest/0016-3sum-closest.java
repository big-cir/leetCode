class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int tMin = Integer.MAX_VALUE;
        int tMax = Integer.MIN_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int p1 = i + 1;
            int p2 = n - 1;
            while (p1 < p2) {
                int sum = nums[i] + nums[p1] + nums[p2];
                if (sum == target) return target;
                if (sum < target) {
                    tMax = Math.max(tMax, sum);
                    p1++;
                }

                if (sum > target) {
                    tMin = Math.min(tMin, sum);
                    p2--;
                }
            }
        }

        if (tMax == Integer.MIN_VALUE) return tMin;
        return (target - tMax) > (tMin - target) ? tMin : tMax;
    }
}