import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int [][] distance = new int [m+1][n+1]; 
        distance[1][1] = 1;
         int num = 1000000007;
        
        for(int i=0; i<puddles.length; i++){
            distance[puddles[i][0]][puddles[i][1]] = -1;
        }
        
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(distance[i][j] == -1){
                    distance[i][j] = 0;
                }
                else{
                    if(i!=1){
                        distance[i][j] += distance[i-1][j];
                        distance[i][j] %= num;
                    }
                    if(j!=1){
                        distance[i][j] += distance[i][j-1];
                        distance[i][j] %= num;
                    }
                }
            }
        }
 
         answer = distance[m][n];

        return answer;
    }
    
}
