class Solution {
    public int search(int[] nums, int target) {
        int lt = 0;
        int rt = nums.length - 1;
        
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            
            if (nums[mid] <= target) {
                if (nums[mid] == target) return mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return -1;
    }
}
