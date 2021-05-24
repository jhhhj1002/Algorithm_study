package baekjoon_Algorithm;
import java.util.*;

public class baekjoon_1904 {
	
	static int num = 15746;
	static int N;
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		solution("");
		System.out.println(count);

	}
	
	public static void solution(String str) { 
		
		if(str.length() >= N) {
			if(str.length() == N) {
				count ++;
				count %= num;
			}
			return;
		}
		
		solution(str + "00");
		solution(str + "1");
		
	}

}
