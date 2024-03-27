class Solution {
    public int reverse(int x) {
        long answer = 0;
        while (x != 0) {
            answer *= 10;
            answer += (x % 10);
            x /= 10;
        }
        
        if (-Integer.MAX_VALUE <= answer && answer <= Integer.MAX_VALUE) {
            return (int) answer;
        } else {
            return 0;
        }
    }
    
    public boolean rangeCheck(int x) {
        return x <= Integer.MAX_VALUE && x >= Integer.MIN_VALUE;
    }
}