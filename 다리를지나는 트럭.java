import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int index = 0;
        Queue <Integer> bridge = new LinkedList<>();
        int sum = 0;
        for(int i=0; i<bridge_length; i++ ){
            bridge.add(0);
        }
       
        while(true){
            if(bridge.size() == 0){
                break;
            }else{
                int head = bridge.poll();
                sum -= head;
                if(index < truck_weights.length){
                    if(sum + truck_weights[index] <= weight){
                    bridge.add(truck_weights[index]);
                    sum += truck_weights[index];
                    index ++;
                    }else{
                        bridge.add(0);
                    }
                }
                
                answer++;
            }
            
        }
 
        return answer;
    }
}