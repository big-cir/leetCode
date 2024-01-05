class Solution {
    public int search(int[] nums, int target) {
        Arrays.sort(nums);
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int target, int lt, int rt) {
        if (rt < lt) return -1;
        int mid = (lt + rt) / 2;
        if (nums[mid] <= target) {
            if (nums[mid] == target) return mid;
            return binarySearch(nums, target, mid + 1, rt);
        } else {
            return binarySearch(nums, target, lt, mid - 1);
        }
    }
}