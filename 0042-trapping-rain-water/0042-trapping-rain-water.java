class Solution {
    public int trap(int[] height) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int idx = stack.pop();
                
                if (stack.isEmpty()) break;
                int gapIdx = i - stack.peek() - 1;
                int rain = Math.min(height[i], height[stack.peek()]) - height[idx];
                answer += (gapIdx * rain);
            }
            stack.push(i);
        }
        return answer;
    }
}