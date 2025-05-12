class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int answer = Integer.MAX_VALUE;
        int lt = 0;
        int rt = 500 * 50000;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            int day = 1;
            int sum = 0;
            for (int weight : weights) {
                if (weight > mid) {
                    day = days + 1;
                    break;
                }
                
                if (sum + weight > mid) {
                    day++;
                    sum = 0;
                }

                sum += weight;
            }

            if (day > days) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        
        return answer;
    }
}