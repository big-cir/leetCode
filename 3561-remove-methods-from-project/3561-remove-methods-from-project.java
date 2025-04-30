class Solution {

    static List<List<Integer>> graph;
    static Set<Integer> set;

// 1 <= n <= 10^5
// 0 <= k <= n - 1
// 0 <= invocations.length <= 2 * 10^5

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> answer = new ArrayList<>();
        set = new HashSet<>();

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < invocations.length; i++) {
            int[] info = invocations[i];
            int from = info[0];
            int to = info[1];

            graph.get(from).add(to);
        }

        int[] ch = new int[n];
        // Arrays.fill(ch, -1);
        ch[k] = 1;
        findKLoad(k, ch, k);

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 1) continue;
            if (!flag) break;

            for (int next : graph.get(i)) {
                if (set.contains(next)) {
                    set.clear();
                    flag = false;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                answer.add(i);
            }
        }

        return answer;
    }

    private void findKLoad(int node, int[] ch, int k) {
        set.add(node);
        for (int next : graph.get(node)) {
            if (ch[next] == 0) {
                ch[next] = 1;
                findKLoad(next, ch, k);
            }
        }
    }
}