class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char x : s.toCharArray()) {
            if (x == '(' || x == '[' || x == '{') stack.push(x);
            else {
                if (x == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') return false;
                    stack.pop();
                } else if (x == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop();
                } else if (x == '}') {
                    if (stack.isEmpty() || stack.peek() != '{') return false;
                    stack.pop();
                } 
            }
        }
        
        if (stack.isEmpty()) return true;
        return false;
    }
}