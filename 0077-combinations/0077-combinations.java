class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>());

        while (!queue.isEmpty()) {
            List<Integer> sub = queue.poll();
            if (sub.size() == k) {
                answer.add(new ArrayList<>(sub));
                continue;
            }

            // 부분집합의 마지막 요소 다음에 올 수 있는 숫자를 가리키는 변수입니다.
            int i = 1;

            // 부분집합이 비어 있지 않은 경우, 마지막 요소의 값을 i에 저장합니다.
            if (!sub.isEmpty()) {
                i = sub.get(sub.size() - 1) + 1;
            }

            // i가 n보다 작을 때까지 반복합니다.
            while (i <= n) {
                // 현재의 부분집합에 숫자를 추가합니다.
                List<Integer> newSub = new ArrayList<>(sub);
                newSub.add(i);

                // 업데이트된 부분집합을 큐에 추가합니다.
                queue.offer(newSub);

                // 다음 숫자로 이동합니다.
                i++;
            }
        }

        return answer;
    }
}