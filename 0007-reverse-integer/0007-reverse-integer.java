class Solution {
    public int reverse(int x) {
        long res = 0;

        while (x != 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }

        if (-Integer.MAX_VALUE <= res && res <= Integer.MAX_VALUE) {
            return (int) res;
        } else {
            return 0;
        }
    }
}