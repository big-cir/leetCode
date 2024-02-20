class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String x : words) map.put(x, map.getOrDefault(x, 0) + 1);

        List<Integer> answer = new ArrayList<>();
        int count = words.length;
        int size = words[0].length();
        int totalLength = size * words.length;

        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> map2 = new HashMap<>();
            int cnt = 0;
            String tmp = s.substring(i, i + totalLength);
            while (count > cnt) {
                String tmp2 = tmp.substring(cnt * size, (cnt + 1) * size);
                if (!map.containsKey(tmp2)) break;

                map2.put(tmp2, map2.getOrDefault(tmp2, 0) + 1);
                if (map2.get(tmp2) > map.get(tmp2)) break;
                cnt++;
            }

            if (cnt == count) answer.add(i);
        }

        return answer;
        
    }
}