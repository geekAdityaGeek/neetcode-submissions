class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap();
        for(int n: nums) {
            int cnt = freq.getOrDefault(n, 0);
            freq.put(n, cnt+1);
        }
        List<List<Integer>> buckets = new ArrayList();
        for(int i=0;i<=nums.length;i++) {
            buckets.add(new ArrayList());
        }
        for(int key : freq.keySet()) {
            int f = freq.get(key);
            buckets.get(f).add(key);
        }
        //System.out.println(buckets);
        List<Integer> ans = new ArrayList();
        int pos = nums.length;
        while(k>0 && pos >= 0) {
            List<Integer> list = buckets.get(pos);
            if(!list.isEmpty()){
                k = k-list.size();
                ans.addAll(list);
                //System.out.println(ans);
            }
            pos--;
        }
        int[] res = new int[ans.size()];
        for(int i=0;i<res.length;i++) {
            res[i] = ans.get(i);
        } 
        return res;
        
    }
}
