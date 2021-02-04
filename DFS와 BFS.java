import java.util.*;

public class Main{
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int V = scan.nextInt();
        
        int [][] matrix = new int [N+1][N+1]; // 인덱스로 계산하기 위해 0은 없다고 침
        
        for(int i=0; i<M; i++){ // matrix 설정, 정점 연결된 경우 1
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            matrix[num1][num2] = 1;
            matrix[num2][num1] = 1;
        }
        
        dfs(V, matrix, N);
        System.out.println("");
        bfs(V, matrix, N);
    }
    
    public static void dfs(int V, int[][] matrix, int N){
        boolean [] visited = new boolean [N+1];
        Stack <Integer> stack = new Stack<>();
        stack.push(V);
        System.out.print(V+" ");
        visited[V] = true;
        while(!stack.empty()){
            int temp = stack.peek();
              
            boolean flag = false;
            for(int i=1; i<N+1; i++){
                if(matrix[temp][i] == 1 && !visited[i]){
                    stack.push(i);
                    System.out.print(i+" ");
                    visited[i] = true;
                    flag = true;
                    break;
                }
            }
            if(!flag)
                stack.pop();
        }
    }
    
    public static void bfs(int V, int[][] matrix, int N){
        boolean [] visited = new boolean [N+1];
        Queue <Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;
        while(queue.size() != 0){
            int temp = queue.peek();
            queue.remove();
            System.out.print(temp+" ");
            for(int i=1; i<N+1; i++){
                if(matrix[temp][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        
        
    }
}