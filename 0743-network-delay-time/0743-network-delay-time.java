class Solution {
    static class Node implements Comparable<Node> {
        private int vertex;
        private int cost;
        
        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < times.length; i++) graph.get(times[i][0]).add(new Node(times[i][1], times[i][2]));
        
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            for (Node next : graph.get(now.vertex)) {
                if (distance[next.vertex] > now.cost + next.cost) {
                    distance[next.vertex] = now.cost + next.cost;
                    pq.offer(new Node(next.vertex, now.cost + next.cost));
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) return -1;
            answer = Math.max(distance[i], answer);
        }
        
        return answer;
    }
}