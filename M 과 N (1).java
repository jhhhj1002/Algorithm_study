package baekjoon_Algorithm;

import java.util.*;

public class baekjoon_15649 {
	
	static int [] arr;
	static int N,M;
	static boolean [] flag;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int [M];

		boolean [] flag = new boolean [N+1];
		
		solution(0,flag);

	}
	
	public static void solution(int index,boolean [] flag ) {
		
		
		if(index == M) {
			for(int s : arr) {
				System.out.print(s + " ");
			}
			System.out.println();	
			
		}else {
			for(int i=1; i<=N; i++) {			
				if(!flag[i]) {
					boolean [] flag2 = new boolean [N+1];
					System.arraycopy(flag, 0, flag2, 0, N+1);
					flag2[i] = true;
					arr[index] = i;
					solution(index + 1,flag2);
				}
			}
		}
		
	}

}
