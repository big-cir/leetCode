class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int lt = 0;
        int cost = 0;
        int answer = 0;
        for (int rt = 0; rt < s.length(); rt++) {
            cost += Math.abs(s.charAt(rt) - t.charAt(rt));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(lt) - t.charAt(lt));
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }
}

// "abcd" "cdef", 1
// 