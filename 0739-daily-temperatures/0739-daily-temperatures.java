class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                if (temperatures[stack.peek()] < temperatures[i]) {
                    int idx = stack.pop();
                    answer[idx] = i - idx;
                } else {
                    break;
                }
            }

            stack.push(i);
        }

        return answer;
    }
}