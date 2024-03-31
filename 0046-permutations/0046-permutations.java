class Solution {
    static List<List<Integer>> answer;
    static int[] ch;
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        ch = new int[nums.length];
        backtrack(new ArrayList<>(), nums);
        return answer;
    }
    
    private void backtrack(List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            answer.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                list.add(nums[i]);
                backtrack(list, nums);
                list.remove(Integer.valueOf(nums[i]));
                ch[i] = 0;
            }
            
        }
    }
}