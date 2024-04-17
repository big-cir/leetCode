class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) list.add(new ArrayList<>());
        
        // 0을 수강하려면 먼저 1을 수강
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] info = prerequisites[i];
            list.get(info[0]).add(info[1]);
            indegree[info[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] ch = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                ch[i] = 1;
            }
        }
    
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : list.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0 && ch[next] == 0) {
                    ch[next] = 1;
                    queue.offer(next);
                }
            }
        }
        
        for (int x : ch) {
            if (x == 0) return false;
        }
        return true;
    }
}