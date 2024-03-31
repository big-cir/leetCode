class Solution {
    static List<List<Integer>> answer;
    
    public List<List<Integer>> combine(int n, int k) {
        answer = new ArrayList<>();
        combi(1, n, k, new ArrayList<>());
        return answer;
    }
    
    private void combi(int start, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            answer.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            list.add(i);
            combi(i + 1, n, k, list);
            list.remove(Integer.valueOf(i));
        }
        
    }
}