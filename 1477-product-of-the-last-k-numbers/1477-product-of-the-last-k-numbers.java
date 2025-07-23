
// add: 정수 추가
// getProduct: k개의 곱 반환
class ProductOfNumbers {

    private List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num == 0) {
            list.clear();
            return;
        }

        if (list.isEmpty()) list.add(1);
        list.add(num * list.get(list.size() - 1));
    }
    
    public int getProduct(int k) {
        int size = list.size();
        if (k >= size) return 0;

        return list.get(size - 1) / list.get(size - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */