class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) stack.push(i);
            else {
                if (temperatures[stack.peek()] > temperatures[i]) {
                    stack.push(i);
                    continue;
                }

                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    int idx = stack.pop();
                    answer[idx] = i - idx;
                }
                stack.push(i);
            }
        }
        return answer;
    }
}