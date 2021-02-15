import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int [n];
        int size = 0;
        ArrayList <Integer> array = new ArrayList<>();

        for(int i=1; i<n+1; i++){
            array.add(i);
        }

        int length = n; // 전체 개수
        long index = k; // 인덱스
        
        long factorial_num = 1;
        for(int i=(n-1); i>0; i--){
            factorial_num *= i;
        }

        while(index != 0){
            long num1 = (index / factorial_num);
            long num2 = (index % factorial_num);
            long temp = (num2 == 0) ? num1 : (num1+1);
            answer[size++] = array.get((int)(temp-1));
            array.remove((int)(temp-1));
            index = num2;
            factorial_num /= (--length);
        }

        if(index == 0){
            for(int i=array.size()-1; i>=0; i--){
                answer[size++] = array.get(i);
            }    
        }

        return answer;
    }

}