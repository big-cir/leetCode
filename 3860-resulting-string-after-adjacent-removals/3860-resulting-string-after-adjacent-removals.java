class Solution {
    public String resultingString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) stack.push(ch);
            else {
                if (check(stack.peek(), ch)) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        // String answer = "";
        StringBuilder answer = new StringBuilder();
        for (char ch : stack) answer.append(ch);
        return answer.toString();
    }

    private boolean check(char prev, char cur) {
        if ((cur == 'a' && prev == 'z') || (cur == 'z' && prev == 'a')) return true;
        return Math.abs(prev - cur) == 1;
    }
}

// 영어 소문자로 구성된 문자열 s가 주어집니다.
// 문자열 s에 두 개 이상의 연속 문자가 있는 동안 다음 연산을 반복적으로 수행해야 합니다:
// 문자열에서 알파벳 순서대로 연속되는 가장 왼쪽에 있는 인접한 문자 쌍을 제거합니다(예: ‘a'와 'b’ 또는 ‘b'와 'a’).
// 나머지 문자를 왼쪽으로 이동하여 간격을 채웁니다.
// 더 이상 연산을 수행할 수 없는 경우 결과 문자열을 반환합니다.
// 참고: 알파벳은 원형이므로 'a'와 'z'는 연속된 것으로 간주합니다.

// 예 1:
// 입력: s = “abc”
// 출력 “c”

// 설명:
// 문자열에서 “ab”를 제거하고 “c”를 나머지 문자열로 남깁니다.
// 더 이상의 연산은 불가능합니다. 따라서 가능한 모든 제거 후 결과 문자열은 “c”가 됩니다.