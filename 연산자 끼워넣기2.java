package baekjoon_Algorithm;

import java.util.*;

public class baekjoon_14888_2 {
	
	static int N;
	static int [] numArr;
	static int [] symbol;
	static ArrayList <Integer> resultArr = new ArrayList <>();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		numArr = new int [N];
		symbol = new int [4];
		
		for(int i=0; i<N; i++) {
			numArr[i] = scan.nextInt();
		}
		
		for(int i=0; i<4; i++) {
			symbol[i] = scan.nextInt();
		}

		solution(1,numArr[0]);
		
		System.out.println(Collections.max(resultArr));
		System.out.println(Collections.min(resultArr));

	}
	
	public static void solution(int depth, int sum) { // depth == numArr 의 index

		
		if(depth == N) {
			resultArr.add(sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			
			int operator = symbol[i];
			
			if(operator != 0) {
				symbol[i]--;
				if(i == 0)
					solution(depth+1, sum + numArr[depth]);
				else if(i==1)
					solution(depth+1, sum - numArr[depth]);
				else if(i==2)
					solution(depth+1, sum * numArr[depth]);
				else {
					solution(depth+1, sum / numArr[depth]);
				}
				symbol[i]++;
			}
		}
	}
}
