class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return divideNConqure(expression);
    }

    public List<Integer> divideNConqure(String expression) {
        List<Integer> list = new ArrayList<>();
        int n = expression.length();
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {
                flag = true;
                List<Integer> left = divideNConqure(expression.substring(0, i));
                List<Integer> right = divideNConqure(expression.substring(i + 1));

                for (int lValue : left) {
                    for (int rValue : right) {
                        if (ch == '+') list.add(lValue + rValue);
                        else if (ch == '-') list.add(lValue - rValue);
                        else if (ch == '*') list.add(lValue * rValue);
                    }
                }
            }
        }

        if (!flag) {
            int num = Integer.parseInt(expression);
            list.add(num);
        }

        return list;
    }
}

// + - *