package baekjoon_Algorithm;
import java.util.*;

public class baekjoon_9416 {

	static long [] arr = new long [101];
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		long [] arrTemp = { 1, 1, 1, 2, 2, 3, 4, 5 };
		System.arraycopy(arrTemp, 0, arr, 1, 8);
		
		for(int i=0; i<count; i++) {
			int N = scan.nextInt();
			long answer = solution(N);
			System.out.println(answer);
		}	

	}
	
	public static long solution(int num) { 
		if( arr[num] == 0 ) {
			return arr[num] = solution(num-5) + solution(num-1);
		}
		return arr[num];
	}

}
