class Solution {
    static List<List<String>> answer;
    public List<List<String>> partition(String s) {
        answer = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        backtrack(0, s, tmp);
        return answer;
    }
    
    private void backtrack(int start, String s, List<String> tmp) {
        if (start == s.length()) {
            answer.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (isPalindrome(str)) {
                tmp.add(str);
                backtrack(i + 1, s, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }
}