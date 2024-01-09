class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         int[] ch = new int[rooms.size()];
//         ch[0] = 1;
//         boolean answer = true;
//         for (int i = 0; i < rooms.size(); i++) {
//             if (ch[i] == 1) {
//                 ch[i] = 0;
                
//                 List<Integer> now = rooms.get(i);
//                 for (int x : now) {
//                     ch[x] = 1;
//                 }
//             } else {
//                 answer = false;
//             }
             
//         }
//         return answer;
        
        return bfs(rooms);
    }
    
    public void dfs(List<List<Integer>> rooms, List<Integer> graph) {
        
    }
    
    private boolean bfs(List<List<Integer>> rooms) {
        boolean flag = true;
        int[] visit = new int[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        visit[0] = 1;
        queue.offer(0);
        
        while (!queue.isEmpty()) {
            int nowRoom = queue.poll();
            
            for (int next : rooms.get(nowRoom)) {
                if (visit[next] == 0) {
                    visit[next] = 1;
                    queue.offer(next);
                }
            }
        }
        
        for (int x : visit) {
            if (x == 0) {
                flag = false;
                break;
            }
        }
        
        return flag;
    }
}