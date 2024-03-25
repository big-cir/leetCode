class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder();
        if (x < 0) {
            return false;
        }
        sb.append(x);
        String tmp = sb.toString();
        return tmp.equals(sb.reverse().toString());
    }
}