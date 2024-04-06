class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int key : nums) set.add(key);
        
        for (int key : set) {
            if (set.contains(key - 1)) continue;
            int cnt = 1;
            int next = key + 1;
            
            while (set.contains(next)) {
                cnt++;
                next++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}