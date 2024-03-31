class Solution {
    static List<List<Integer>> answer;
    static int[] ch;
    
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        ch = new int[nums.length];
        subset(0, new ArrayList<>(), nums);
        return answer;
    }
    
    private void subset(int start, List<Integer> list, int[] nums) {
        if (list.size() > nums.length) return;
        answer.add(new ArrayList<>(list));
        
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            subset(i + 1, list, nums);
            list.remove(Integer.valueOf(nums[i]));
        }
    }
}