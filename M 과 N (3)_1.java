// 첫번째 정답 -> 시간초과
package baekjoon_Algorithm;
import java.util.*;

public class baekjoon_15651 {
	
	static int[] arr;
	static int N, M;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[M];

		solution(0);

	}

	public static void solution(int index) {

		if (index == M) {
			for (int s : arr) {
				System.out.print(s + " ");
			}
			System.out.println();

		} else {
			for (int i = 1; i <= N; i++) {
				arr[index] = i;
				solution(index + 1);
		
			}
		}

	}

}