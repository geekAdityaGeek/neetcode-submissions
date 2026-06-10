class LRUCache {
    HashMap<Integer, Integer> keyVal = new HashMap();

    LinkedList<Integer> ll = new LinkedList();
    int cnt = 0;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!ll.contains(key)) {
            return -1;
        }
        int val = keyVal.get(key);
        ll.remove(Integer.valueOf(key));
        ll.add(key);
        return val;
    }

    public void put(int key, int value) {
        if (ll.contains(key)) {
            keyVal.put(key, value);
            ll.remove(Integer.valueOf(key));
            ll.add(key);
            return;
        }
        if (cnt == capacity) {
            ll.remove(0);
            cnt--;
        }
        ll.add(key);
        keyVal.put(key, value);
        cnt++;
        // System.out.println(ll);
    }
}
