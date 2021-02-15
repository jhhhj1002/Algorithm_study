import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        ArrayList <Paper> arr = new ArrayList<>();
        ArrayList <Integer> priority_arr = new ArrayList<>();
        
        for(int i=0; i<priorities.length; i++ ){
            arr.add(new Paper(i,priorities[i]));
            priority_arr.add(priorities[i]);
        }
        
        int max = Collections.max(priority_arr);
      
        while(true){
            if(arr.get(0).priority >= max){
                if(arr.get(0).location == location){
                    answer ++;
                    break;
                }
                arr.remove(0);
                priority_arr.remove(0);
                max = Collections.max(priority_arr);
                answer ++;
            }else{
                arr.add(arr.get(0));
                arr.remove(0);
                priority_arr.add(priority_arr.get(0));
                priority_arr.remove(0);
            }
        }
      
        return answer;
    }
    
    class Paper{
        int location;
        int priority;
        
        public Paper(int my_location, int my_priority){
            location = my_location;
            priority = my_priority;
        }
    }
    
}