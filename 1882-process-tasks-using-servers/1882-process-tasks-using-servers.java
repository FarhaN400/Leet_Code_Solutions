import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        // Available servers:
        // {weight, index}
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return a[0] - b[0]; // smaller weight
                
                return a[1] - b[1]; // smaller index
            }
        );
        
        // Busy servers:
        // {freeTime, weight, index}
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Long.compare(a[0], b[0]); // earlier free time
                
                if (a[1] != b[1])
                    return Long.compare(a[1], b[1]); // smaller weight
                
                return Long.compare(a[2], b[2]); // smaller index
            }
        );
        
        // Put all servers into available queue
        for (int i = 0; i < servers.length; i++) {
            available.offer(new int[]{servers[i], i});
        }
        
        int[] ans = new int[tasks.length];
        
        long time = 0;
        
        for (int i = 0; i < tasks.length; i++) {
            
            // Task i arrives at time i
            time = Math.max(time, i);
            
            // Move finished servers from busy -> available
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                
                long[] server = busy.poll();
                
                available.offer(new int[]{
                    (int) server[1], // weight
                    (int) server[2]  // index
                });
            }
            
            // If no server is available, wait
            if (available.isEmpty()) {
                
                // Jump time to when the earliest server becomes free
                time = busy.peek()[0];
                
                // Move all servers that become free at this time
                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    
                    long[] server = busy.poll();
                    
                    available.offer(new int[]{
                        (int) server[1],
                        (int) server[2]
                    });
                }
            }
            
            // Choose best available server
            int[] server = available.poll();
            
            int weight = server[0];
            int index = server[1];
            
            ans[i] = index;
            
            // Server will become free after task duration
            busy.offer(new long[]{
                time + tasks[i],
                weight,
                index
            });
        }
        
        return ans;
    }
}