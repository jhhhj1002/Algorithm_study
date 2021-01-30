import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue <Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(Integer k : works){
            queue.add(k);
        }
        
        for(int i=n; i>0; i--){
            int max = queue.poll();
            if(max == 0) break;
            queue.add(max-1);
        }
        
        for(Integer k : queue){
            answer += Math.pow(k,2);
        }
        
        return answer;
    }
}