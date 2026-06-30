class Solution {
    private boolean reachable(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            int delta = s1.charAt(i) == s2.charAt(i) ? 0 : 1 ;
            diff += delta;
        }
        return diff < 2;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        List<String> dict = new ArrayList(new HashSet(wordList));
        System.out.println(dict);
        List<List<Integer>> adj = new ArrayList();
        for (int i = 0; i < dict.size(); i++) {
            adj.add(new ArrayList());
        }
        int startIdx = -1;
        int endIdx = -1;
        int pathLen[] = new int[dict.size()];
        for (int i = 0; i < dict.size(); i++) {
            if (beginWord.equalsIgnoreCase(dict.get(i))) {
                startIdx = i;
            }
            if (endWord.equalsIgnoreCase(dict.get(i))) {
                endIdx = i;
            }
            pathLen[i] = -1;
            for (int j = i + 1; j < dict.size(); j++) {
                if (reachable(dict.get(i), dict.get(j))) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        if(endIdx == -1) {
            return 0;
        }

        //System.out.println(adj);

        Queue<int[]> Q = new LinkedList();
        Q.add(new int[] {startIdx, 0});
        boolean visited[] = new boolean[dict.size()];
        visited[startIdx] = true;
        while (!Q.isEmpty()) {
            int[] ele = Q.remove();
            pathLen[ele[0]] = ele[1];
            for (Integer child : adj.get(ele[0])) {
                if(!visited[child]) {
                    Q.add(new int[] {child, ele[1] + 1});
                    visited[child] = true;
                }
            }
        }

        // for(int n : pathLen) {
        //     System.out.print(n+" : ");
        // }
        // System.out.println();

        return pathLen[endIdx]+1;
    }
}
