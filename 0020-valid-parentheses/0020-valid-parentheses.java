class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        
        if (s.length() % 2 != 0) return false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;
                if (ch == ')' && stack.pop() != '(') return false;
                if (ch == '}' && stack.pop() != '{') return false;
                if (ch == ']' && stack.pop() != '[') return false;
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        if (!stack.isEmpty()) return false;
        
        return true;
    }
}