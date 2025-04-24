class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] lDis = new int[n];
        int[] rDis = new int[n];

        int answer = 0;
        int dis = -2 * 10 * 10 * 10 * 10;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                dis = i;
            }
            lDis[i] = i - dis; 
        }

        dis = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                dis = i;
            }
            rDis[i] = dis - i;
        }

        for (int i = 0; i < n; i++) answer = Math.max(answer, Math.min(lDis[i], rDis[i]));
        
        return answer;
    }
} 