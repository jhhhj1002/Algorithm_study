
class Solution {
    public int solution(int[] numbers, int target) {
        
        int sum = 0;
        int answer = dfs(numbers,target,sum,0) ;
 
        System.out.println(answer);
        return answer;
    }
    
    public int dfs(int[] numbers, int target,int sum, int index){
        
        if(index == numbers.length){
            if(sum == target)
                return 1;
            else
                return 0;
        }
        int result = dfs(numbers, target, sum + numbers[index], index +1) +dfs(numbers, target, sum - numbers[index], index +1) ;

        return result;
    }

}