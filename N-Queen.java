package baekjoon_Algorithm;

import java.util.*;

// 규칙 : 대각선과 같은줄에 퀸이 2개이상 있으면 안됨

public class baekjoon_9663 {

	static int count = 0;
	static int N;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		N = scan.nextInt(); 
		int [] arr = new int [N];

		for (int i = 0; i < N; i++) {
			arr = new int [N];
			arr[0] = i;
			solution(1, arr);
		}

		System.out.println(count);

	}

	
	public static void solution(int depth, int [] arr ) { 
		
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isPossible(arr,depth, i)) {				
				arr[depth] = i;
				solution(depth+1, arr);
			}
		}
	}
	
	
	public static boolean isPossible(int [] arr, int depth, int num) {
		
		for(int i=0; i<depth; i++) {
			if(arr[i] == num) 
				return false;

			if( Math.abs(arr[i]-num) == Math.abs(i-depth))
				return false;
		}
		return true;
	}

}
