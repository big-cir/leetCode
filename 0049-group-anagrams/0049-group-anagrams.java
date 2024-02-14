class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String x : strs) {
            char[] chars = x.toCharArray();
            Arrays.sort(chars);

            String str = new String(chars);
            if (map.containsKey(str)) {
                map.get(str).add(x);
            } else {
                map.put(str, new ArrayList<String>(List.of(x)));
            }
        }

        for (List<String> list : map.values()) answer.add(list);
        return answer;
    }
}