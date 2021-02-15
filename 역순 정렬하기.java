import java.util.*;

class Solution {
    boolean [][] visited;
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        visited = new boolean [n][n];
        
        for(int i=0; i<n; i++){
            if(!visited[i][i]){
                dfs(i,computers);
                answer ++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int index,int[][] computers){
        for(int i=0; i<computers.length; i++){
            if(!visited[index][i] && computers[index][i]==1){
                visited[index][i] = visited[i][index] = true;
                dfs(i,computers);
                
            }
        }
    }
}