class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, new int[nums.length], new ArrayList<>(), answer);
        return answer;
    }
    
    private void backtrack(int[] nums, int[] ch, List<Integer> path, List<List<Integer>> answer) {
        if (path.size() == nums.length) {
            answer.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                path.add(nums[i]);
                backtrack(nums, ch, path, answer);
                path.remove(path.size() - 1);
                ch[i] = 0;
            }
        }
    }
}