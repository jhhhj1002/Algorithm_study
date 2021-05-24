package baekjoon_Algorithm;
import java.util.*;

public class baekjoon_1904_2 {

	static int division = 15746;
	static int N;
	static int [] arr;

	public static void main(String[] args) { 
		
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N+1];
		arr[1] = 1;
		if(N > 1) 
			arr[2] = 2;

		System.out.println(solution(N));

	}
	
	public static int solution(int num) {
		
		if(arr[num] == 0)
			return arr[num] = (solution(num-1) + solution(num-2)) % division;
		return arr[num];
		
	}

}
