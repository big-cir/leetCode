class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        // {value, index}
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[] {nums[i], i});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int lt = 0;
        int rt = nums.length - 1;
        while (lt < rt) {
            int[] prev = list.get(lt);
            int[] now = list.get(rt);

            int sum = prev[0] + now[0];
            if (sum <= target) {
                if (sum == target) {
                    answer[0] = prev[1];
                    answer[1] = now[1];
                    break;
                }
                lt++;
            }
            else {
                rt--;
            }
        }
        return answer;
    }
}