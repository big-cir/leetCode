class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backtrack(0, s, list, answer);
        return answer;
    }
    
    private void backtrack(int start, String s, List<String> list, List<List<String>> answer) {
        if (start == s.length()) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (isPalindrome(sub)) {
                list.add(sub);
                backtrack(i + 1, s, list, answer);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }
}