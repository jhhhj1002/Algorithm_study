import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String [] char_arr = skill.split("");
        Queue <String> queue = new LinkedList<>();
        
        for(int i=0; i<skill_trees.length; i++){
            queue.clear();
            
            for(String k : char_arr){
                queue.add(k);
            }
            
            String [] str_arr = skill_trees[i].split("");
            for(int j=0; j<str_arr.length; j++){
                if(queue.contains(str_arr[j])){
                    if(queue.peek().equals(str_arr[j])){
                         queue.remove();
                        if(queue.size() == 0 || j == str_arr.length-1){
                            answer ++;
                            break;
                        }
                    }
                    else
                        break;
                } if(j == str_arr.length-1)
                    answer ++;
            }
        }
      
        return answer;
    }
}