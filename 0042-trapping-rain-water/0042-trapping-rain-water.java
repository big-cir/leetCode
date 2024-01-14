class Solution {
    public class Element {
        private int idx;
        private int height;

        public Element(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
    
    public int trap(int[] height) {
        int answer = 0;
        Deque<Element> stack = new ArrayDeque<>();

        for (int i = 0; i < height.length; i++) {
            if (!stack.isEmpty()) {
                while (height[i] > stack.peek().height) {
                     Element element = stack.pop();
                     if (stack.isEmpty()) break;

                     int waterWidth = i - stack.peek().idx - 1;
                    int waterHeight = Math.min(height[i], stack.peek().height) - height[element.idx];
                     answer += waterWidth * waterHeight;
                }
            }
            stack.push(new Element(i, height[i]));
        }
        return answer;
    }
}