class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        int maxLength = 0;
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            // odd case
            int lt = i;
            int rt = i;
            while (lt >= 0 && rt < s.length() && s.charAt(lt) == s.charAt(rt)) {
                if (maxLength < rt - lt + 1) {
                    maxLength = rt - lt + 1;
                    answer = s.substring(lt, rt + 1);
                }
                lt--;
                rt++;
            }

            // even case
            lt = i;
            rt = i + 1;
            while (lt >= 0 && rt < s.length() && s.charAt(lt) == s.charAt(rt)) {
                if (maxLength < rt - lt + 1) {
                    maxLength = rt - lt + 1;
                    answer = s.substring(lt, rt + 1);
                }
                lt--;
                rt++;
            }
        }
        return answer;
    }
}