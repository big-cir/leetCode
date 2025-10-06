// in-place
class Solution {
    public int removeDuplicates(int[] nums) {
        int pIdx = 0, vIdx = 0;
        while (pIdx < nums.length && vIdx < nums.length) {
            if (nums[pIdx] == nums[vIdx]) {
                vIdx++;
            } else {
                nums[++pIdx] = nums[vIdx];
            }
        }

        return pIdx + 1;
    }
}