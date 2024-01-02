class Solution {
    static String answer;
    static int cnt;
    public String getPermutation(int n, int k) {
        // List<String> list = new ArrayList<>();
        // for (int i = 1; i <= n; i++) {
        //     String str = String.valueOf(i);
        //     makePermutation(n, k, list, str);
        // }
        // return list.get(k - 1);
        StringBuilder sb = new StringBuilder();
        int[] ch = new int[n + 1];
        cnt = 0;
        answer = "";
        backtrack(n, k, ch, sb);
        return answer;
    }

//     public void makePermutation(int n, int k, List<String> list, String str) {
//         if (str.length() == n) {
//             list.add(str);
//             return;
//         }

//         for (int i = 1; i <= n; i++) {
//             if (str.contains(String.valueOf(i))) continue;
//             makePermutation(n, k, list, str + i);
//             if (list.size() - 1 == k) return;
//         }
//     }
    
    public void backtrack(int n, int k, int[] ch, StringBuilder sb) {
        if (sb.length() == n) {
            cnt++;
            if (cnt == k) answer = sb.toString();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                sb.append(i);
                backtrack(n, k, ch, sb);
                sb.deleteCharAt(sb.length() - 1);
                ch[i] = 0;
            }
        }
    }
}