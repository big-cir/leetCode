class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Set<Character> set = new HashSet<>();
        
        int lt = 0;
        int rt = 0;
        while (lt <= rt && rt < s.length()) {
            if (!set.contains(s.charAt(rt))) {
                set.add(s.charAt(rt++));
            } else {
                set.remove(s.charAt(lt++));
            }
            
            answer = Math.max(answer, set.size());
        }
        
        return answer;
    }
}