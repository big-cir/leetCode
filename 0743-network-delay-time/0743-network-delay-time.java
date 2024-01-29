class Solution {
    
    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            list.get(time[0]).add(new Node(time[1], time[2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));
        
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : list.get(now.v)) {
                if (dis[next.v] > now.cost + next.cost) {
                    dis[next.v] = now.cost + next.cost;
                    pq.offer(new Node(next.v, now.cost + next.cost));
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE) return -1;
            answer = Math.max(answer, dis[i]);
        }

        return answer;
    }
}