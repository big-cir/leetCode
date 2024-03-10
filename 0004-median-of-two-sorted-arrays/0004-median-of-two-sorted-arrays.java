class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums1) list.add(x);
        for (int x : nums2) list.add(x);
        Collections.sort(list);
        
        double answer = 0.0;
        int size = list.size();
        if (size % 2 == 0) {
            int idx = size / 2;
            double number1 = list.get(idx - 1);
            double number2 = list.get(idx);
            answer = Math.round((number1 + number2) / 2.0 * 10000.0) / 10000.0;
        } else {
            int idx = size / 2;
            System.out.println(idx);
            double number = (double) list.get(idx);
            answer = Math.round(number * 10000) / 10000;
        }
        return answer;
    }
}