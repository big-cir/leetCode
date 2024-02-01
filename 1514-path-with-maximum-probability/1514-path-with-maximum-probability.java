class Solution {
    static class Node implements Comparable<Node>{
        int vertex;
        double cost;

        public Node(int vertex, double cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(o.cost, cost);
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Node(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Node(edges[i][0], succProb[i]));
        }

        double[] dis = new double[n];
        Arrays.fill(dis, Double.MIN_VALUE);
        int[] ch = new int[n];

        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start_node, 1));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            ch[now.vertex] = 1;
            
            // if (dis[now.vertex] > now.cost) continue;

            for (Node next : graph.get(now.vertex)) {
                if (ch[next.vertex] == 0) {
                    if (dis[next.vertex] < now.cost * next.cost) {
                        dis[next.vertex] = now.cost * next.cost;
                        pq.offer(new Node(next.vertex, now.cost * next.cost));
                    }
                }
            }
        }

        return dis[end_node] == Double.MIN_VALUE ? 0 : dis[end_node];
        
    }
}