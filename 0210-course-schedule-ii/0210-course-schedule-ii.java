class Solution {
    static List<List<Integer>> graph;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]] += 1;
        }

        int[] ch = new int[numCourses];
        Arrays.fill(ch, -1);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

//        System.out.println(Arrays.toString(indegree));
        int rank = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            ch[rank++] = now;

            for (int next : graph.get(now)) {
                if (indegree[next] >= 1) {
                    indegree[next]--;
                }

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        for (int x : ch) {
            if (x == -1) return new int[] {};
        }

        return ch;
    }
}