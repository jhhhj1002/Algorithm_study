package baekjoon;

import java.util.*;

public class baekjoon_2775 {
	
	static int [][] matrix; 
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		
		for(int i=0; i<testcase; i++) {
			int K = scan.nextInt();
			int N = scan.nextInt();
			matrix = new int [K+1][N+1]; // K는 0층부터, N은 1호부터
			int answer = solution(K,N);
			System.out.println(answer);
		}
		
	}
	
	public static int solution(int K, int N) {
		
		for(int i=1; i<N+1; i++) {
			matrix[0][i] = i;
		}
		
		for(int i=0; i<K+1; i++) {
			matrix[i][1] = 1;
		}
		
		// 여기부터 순차적으로 합 계산 
		
		for(int i=1; i<K+1; i++) {
			for(int j=2; j<N+1; j++) {
				matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
			}
		}
		
		return matrix[K][N];
	}

}
