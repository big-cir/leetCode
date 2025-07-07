class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int[] ch = new int[n];
            boolean posit = nums[i] > 0;

            int cnt = 0;
            int idx = i;
            while (true) {
                boolean nDir = nums[idx] > 0;
                if (posit != nDir) break;
                if (ch[idx] == 1) {
                    if (cnt > 1) return true;
                    break;
                }

                cnt++;
                ch[idx] = 1;
                int next = ((idx + nums[idx]) % n + n) % n;
                if (next == idx) break;
                idx = next;
            }
        }

        return false;
    }
}

// n = 5
// 0 -> 3 