class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        int cnt = t.length();

        int[] answer = new int[2];
        answer[0] = -1;
        int lt = 0;
        int rt = 0;
        int max = Integer.MAX_VALUE;
        
        while (lt <= rt && rt < s.length()) {
            char ch = s.charAt(rt);
            if (map.containsKey(ch) && map.get(ch) > 0) cnt--;
            if (map.containsKey(ch)) map.put(ch, map.get(ch) - 1);
            rt++;

            if (cnt == 0) {
                while (cnt < 1) {
                    if (max > (rt - lt)) {
                        max = rt - lt;
                        answer[0] = lt;
                        answer[1] = rt;
                    }

                    char ch2 = s.charAt(lt);
                    if (map.containsKey(ch2)) {
                        map.put(ch2, map.getOrDefault(ch2, 0) + 1);
                        if (map.get(ch2) > 0) cnt++;
                    }
                    lt++;
                }
            }
        }

        if (answer[0] == -1) return "";
        return s.substring(answer[0], answer[1]);
    }
}