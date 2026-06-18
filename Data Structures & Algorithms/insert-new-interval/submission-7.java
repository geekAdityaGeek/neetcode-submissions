class Solution {
    private void print(List<int[]> intervalList) {
        for (int[] interval : intervalList) {
            System.out.println(interval[0] + ":" + interval[1]);
        }
        System.out.println("-------------------");
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList();
        boolean isInserted = false;
        for (int[] interval : intervals) {
            if (!isInserted && newInterval[0] <= interval[0]) {
                isInserted = true;
                intervalList.add(newInterval);
            }
            intervalList.add(interval);
        }
        if(!isInserted) {
            isInserted = true;
            intervalList.add(newInterval);
        }

        //print(intervalList);

        int pos = 0;
        for (int[] interval : intervalList) {
            if (interval[0] <= intervalList.get(pos)[1]) {
                intervalList.get(pos)[0] = Math.min(intervalList.get(pos)[0], interval[0]);
                intervalList.get(pos)[1] = Math.max(intervalList.get(pos)[1], interval[1]);
            } else {
                pos++;
                intervalList.get(pos)[0] = interval[0];
                intervalList.get(pos)[1] = interval[1];
            }
            //print(intervalList);
        }

        int res[][] = new int[pos + 1][2];
        for (int i = 0; i <= pos; i++) {
            res[i] = intervalList.get(i);
        }

        return res;
    }
}
