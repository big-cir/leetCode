// 정렬된 list
// nums <= k
// 50
// worst = O(50^3500)

// 큐에 순서대로 떄려넣고 3개씩? --> O(3500 * 50)
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // {list idx, idx, value}
        int[] max = {0, 0, -100000};
        Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[2] - e2[2]);
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i).get(0);
            pq.offer(new int[] {i, 0, num});
            
            if (num > max[2]) {
                max[0] = i;
                max[2] = num;
            }
        }
        
        int[] answer = {-100000, max[2]};
        while (!pq.isEmpty()) {
            int[] min = pq.poll();
            
            if (answer[1] - answer[0] > max[2] - min[2]) {
                answer[0] = min[2];
                answer[1] = max[2];
            }
            
            int rmListIdx = min[0];
            int listOfNextIdx = min[1] + 1;
            
            if (listOfNextIdx == nums.get(rmListIdx).size()) break;
            
            int nextValue = nums.get(rmListIdx).get(listOfNextIdx);
            if (nextValue > max[2]) {
                max[0] = rmListIdx;
                max[1] = listOfNextIdx;
                max[2] = nextValue;
            }
            
            pq.offer(new int[] {rmListIdx, listOfNextIdx, nextValue});
        }
        
        return answer;
    }
}
