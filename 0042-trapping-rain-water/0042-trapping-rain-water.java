class Solution {
    static class Info {
        private int idx;
        private int h;

        public Info(int idx, int h) {
            this.idx = idx;
            this.h = h;
        }
    }
    
    public int trap(int[] height) {
        int answer = 0;
        Deque<Info> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty()) {
                int top_Height = stack.peek().h;
                int now_Height = height[i];
                if (top_Height < now_Height) {
                    Info top = stack.pop();
                    if (stack.isEmpty()) break;
                    int dis = i - stack.peek().idx - 1;

                    int h = Math.min(height[i], stack.peek().h) - height[top.idx];
                    answer += dis * h;
                } else {
                    break;
                }
            }
            stack.push(new Info(i, height[i]));
        }
        return answer;
    }
}