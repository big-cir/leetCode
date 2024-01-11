class Solution {
    public int longestValidParentheses(String s) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    answer = Math.max(answer, i - stack.peek());
                } else {
                    stack.push(i);
                }

            } else {
                stack.push(i);
            }
        }
        return answer;
    }
}