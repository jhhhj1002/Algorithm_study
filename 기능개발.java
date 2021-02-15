import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            int progress = progresses[i];
            int speed = speeds[i];
            int day = (100 - progress)/speed;
            day = ((100 - progress)%speed == 0) ? day : day+1 ;
            
            if(queue.size() == 0)
                queue.add(day);
            else{
                if(queue.peek() >= day)
                    queue.add(day);
                else{
                    arr.add(queue.size());
                    queue.clear();
                    queue.add(day);
                }
            }
        }
        
        if(queue.size() !=0 ){
            arr.add(queue.size());
        }
        
        int[] answer = new int [arr.size()];
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}