class Solution {
    public int longestConsecutive(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int cnt = 1;
                int next = x + 1;
                
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