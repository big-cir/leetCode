class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] info = prerequisites[i];
            indegree[info[0]]++;
            graph.get(info[1]).add(info[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        
        int[] ch = new int[numCourses];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            ch[now] = 1;
            
            for (int next : graph.get(now)) {
                indegree[next]--;
                
                if (indegree[next] == 0 && ch[next] == 0) {
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