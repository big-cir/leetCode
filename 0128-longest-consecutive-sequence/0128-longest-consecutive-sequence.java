class Solution {
    public int longestConsecutive(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if (!set.contains(num - 1)) {
                int cnt = 1;
                int next = num + 1;
                
                while (set.contains(next)) {
                    cnt++;
                    next++;
                }
                answer = Math.max(answer, cnt);
            }
        }
        
        return answer;
    }
}