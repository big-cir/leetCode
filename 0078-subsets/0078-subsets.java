class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(0, nums, new ArrayList<Integer>(), answer);
        return answer;
    }
    
    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i + 1, nums, path, answer);
            path.remove(path.size() - 1);
        }
    }
}