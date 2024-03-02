class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        // index를 저장
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                if (temperatures[i] > temperatures[stack.peek()]) {
                    answer[stack.peek()] = i - stack.pop();
                } else {
                    break;
                }
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}