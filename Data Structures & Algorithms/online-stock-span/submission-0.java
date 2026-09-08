class StockSpanner {

    List<Integer> prices;

    public StockSpanner() {
        prices = new ArrayList();
    }
    
    public int next(int price) {
        int cnt = 1 ;
        int idx = prices.size()-1;
        while(idx >= 0 && prices.get(idx) <= price) {
            idx--;
            cnt++;
        }
        prices.add(price);
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */