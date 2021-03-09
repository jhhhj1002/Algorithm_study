import java.util.*;

class Solution {

    int solution(int[][] land) {
        int answer = 0;
        int max = 0;
        int size = land.length;
        int [][] matrix = new int[size][4]; // 원본 배열 저장
        int [][] score = new int[size][4]; // 합산한 배열 저장


        for(int k=0; k<land.length; k++){
            System.arraycopy(land[k], 0, score[k], 0, 4);
            System.arraycopy(land[k], 0, matrix[k], 0, 4);
        }
      

        for(int i=0; i<size-1; i++){

            int [] temp = new int[4];
            System.arraycopy(score[i], 0, temp, 0, 4);
            Arrays.sort(temp);

            int Index1 = 0; // 제일 큰 값의 인덱스
            int Index2 = 0; // 두번째로 큰 값의 인덱스

            for(int k=0; k<4; k++){
                if(score[i][k] == temp[3]){
                    Index1 = k;
                }
                if(score[i][k] == temp[2]){
                    Index2 = k;
                }

            }

            score[i+1][Index1] = score[i][Index2] + matrix[i+1][Index1];
            for(int k=0; k<4; k++){
                if(k != Index1){
                    score[i+1][k] = score[i][Index1] + matrix[i+1][k];
                }
            }
        }

        answer = Math.max(score[size-1][0],score[size-1][1]);
        answer = Math.max(answer,score[size-1][2]);
        answer = Math.max(answer,score[size-1][3]);

        return answer;
    }
}
