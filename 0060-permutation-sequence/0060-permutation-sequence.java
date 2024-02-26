class Solution {
    static List<String> list;
    public String getPermutation(int n, int k) {
        list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] ch = new int[n + 1];
        backtrack(sb, n, k, ch);
        return list.get(k - 1);
    }
    
    private void backtrack(StringBuilder sb, int n, int k, int[] ch) {
        if (list.size() == k) return;
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                sb.append(i);
                backtrack(sb, n, k, ch);
                sb.deleteCharAt(sb.length() - 1);
                ch[i] = 0;
            }
        }
    }
}