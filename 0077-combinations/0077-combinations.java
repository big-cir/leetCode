class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        recursive(0, 1, n, k, new ArrayList<Integer>(), answer);
        return answer;
    }
    
    private void recursive(int level, int num, int n, int k, List<Integer> sub, List<List<Integer>> answer) {
        if (level == k) {
            answer.add(new ArrayList<>(sub));
            return;
        }
    
        for (int i = num; i <= n; i++) {
            sub.add(i);
            recursive(level + 1, i + 1, n, k, sub, answer);
            sub.remove(Integer.valueOf(i));
        }
    }
}