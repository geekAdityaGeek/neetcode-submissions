class Solution {
    public int[] getOrder(int[][] tasks) {
        Task[] task = new Task[tasks.length];
        PriorityQueue<Task> pq = new PriorityQueue<Task>( (a,b) -> a.t - b.t );
        for(int i = 0 ; i < tasks.length ; i++) {
            task[i] = new Task(tasks[i][0], tasks[i][1], i);
        }
        Arrays.sort(task, (a, b) -> {
            if(a.enq - b.enq == 0) {
                return a.t-b.t;
            }
            return a.enq - b.enq;
        });
        // for(Task t : task) {
        //     System.out.print(t+" | ");
        // }
        // System.out.println();

        int currTime = task[0].enq;
        pq.add(task[0]);
        int i = 1;
        int ans[] = new int[tasks.length];
        int r = 0;
        while(!pq.isEmpty()) {
            Task t = pq.remove();
            currTime += t.t;
            ans[r] = t.idx;
            r++; 
            while(i < task.length && currTime >= task[i].enq) { 
                pq.add(task[i]);
                i++;
            }
            if(pq.isEmpty() && i < task.length) {
                pq.add(task[i]);
                i++;
            }
            //System.out.println(currTime + " | " +pq);
        }
        return ans;
    }
}

class Task {
    int enq;
    int t;
    int idx;
    Task(int e, int t, int idx) { 
        enq = e;
        this.t = t;
        this.idx = idx; 
    }
    public String toString() {
        return "("+idx+" : "+enq+" : "+t+")";
    }
}