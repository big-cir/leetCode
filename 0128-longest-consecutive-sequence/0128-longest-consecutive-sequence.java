class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> numsHashSet = new HashSet<>();;
        for (int i = 0; i < nums.length; i++) {
            numsHashSet.add(nums[i]);;
        }
        
        for (int num : numsHashSet) {
            if (!numsHashSet.contains(num - 1)) {
                int cnt = 1;
                int target = num + 1;
                while (numsHashSet.contains(target)) {
                    target++;
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest; 
    }
}