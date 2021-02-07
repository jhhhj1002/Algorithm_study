import java.util.*;

public class Main{
    static boolean [][] visited;
    
    public static void main(String []args){
        int max = 1; // 비가 안올 때 최대 영역 개수
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int [][] matrix = new int [N][N];
        scan.nextLine();
        
        for(int i=0; i<N; i++){ // matrix 값 설정
            String temp = scan.nextLine();
            String [] strArr = temp.split(" ");
            for(int j=0; j<N; j++){
                matrix[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        
        for(int length = 1; length<=100; length++){
            visited = new boolean[N][N];
            int result = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i][j]!=true && matrix[i][j]>length){
                        dfs(i,j,N,matrix,length);
                        result ++;
                    }
                }
            }
            
            if(result > max){
                max = result;
            }
        }
        
        System.out.println(max);
    }
    
    public static void dfs(int index1, int index2, int N, int[][] matrix, int length){
        if((index2 != N-1) && matrix[index1][index2+1] > length && visited[index1][index2+1]!=true){
            visited[index1][index2+1] = true;
            dfs(index1,index2+1,N,matrix,length);
        }
        if((index1 != N-1) && matrix[index1+1][index2] > length && visited[index1+1][index2]!=true){
            visited[index1+1][index2] = true;
            dfs(index1+1,index2,N,matrix,length);
        }
        if((index1 > 0) && matrix[index1-1][index2] > length && visited[index1-1][index2]!=true){
            visited[index1-1][index2] = true;
            dfs(index1-1,index2,N,matrix,length);
        }
        if((index2 > 0) && matrix[index1][index2-1] > length && visited[index1][index2-1]!=true){
            visited[index1][index2-1] = true;
            dfs(index1,index2-1,N,matrix,length);
        }
    }
    

}