class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> freq = new TreeMap();
        for (int n : hand) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        Set<Integer> keys = freq.keySet();
        for (int key : keys) {
            // System.out.println(freq);
            int val = freq.get(key);
            if (val < 0) {
                return false;
            }
            if (val == 0) {
                continue;
            }
            for (int offset = 0; offset < groupSize; offset++) {
                int nextEle = key + offset;
                if (!freq.containsKey(nextEle) || freq.get(nextEle) <= 0) {
                    return false;
                }
                freq.put(nextEle, freq.get(nextEle) - val);
            }
        }

        return true;
    }
}
