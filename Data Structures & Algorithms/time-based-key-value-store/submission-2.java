class TimeMap {
    HashMap<String, List<String[]>> store = new HashMap();

    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        List<String[]> list = store.getOrDefault(key, new ArrayList());
        list.add(new String[] {"" + timestamp, value});
        store.put(key, list);
    }

    public String get(String key, int timestamp) {
        List<String[]> data = store.getOrDefault(key, new ArrayList());
        int low = 0, high = data.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int t = Integer.parseInt(data.get(mid)[0]);
            if (t == timestamp) {
                return data.get(mid)[1];
            } else if (timestamp > t) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if(high < 0) {
            return "";
        } 
        int t = Integer.parseInt(data.get(high)[0]);
        return timestamp < t ? "" :  data.get(high)[1];
    }
}
