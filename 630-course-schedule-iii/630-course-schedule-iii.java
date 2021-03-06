class Solution {
    // here pq is max heap
    // valid: in whihc the total dur. is in limit 
    // else invalid
    
    // the main idea if adding the valid course in pq
    // if a unvalid course occur then check the pq.peek()
    // if it is less than curr course duration then swap these two
    // return size of pq.
    
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> {
            return a[1] - b[1];
        });
        int calc = 0, ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i[] : courses){
            int temp = calc + i[0];
            if(temp <= i[1]){
                pq.offer(i[0]);
                calc = temp;
            }else if(pq.size() > 0 && pq.peek() > i[0]){
                calc -= pq.poll();
                pq.offer(i[0]);
                calc += i[0];
            }
            else continue;
        }
        return pq.size();
    }
}