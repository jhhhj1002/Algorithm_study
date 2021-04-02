import java.util.*;

public class baekjoon_2609{
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        int M = scan.nextInt();
        
        int num = solution(N,M);
        System.out.println(num);
        System.out.println(N*M/num);
        
        
    }
    
    public static int solution(int N, int M){
        if(N%M == 0)
            return M;
        else
            return solution(M, N%M);
    }
}