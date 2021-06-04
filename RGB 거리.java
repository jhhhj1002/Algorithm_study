package baekjoon_Algorithm;
import java.util.*;

public class baekjoon_1149 { // 최소값 누적시키면서 내려가기

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int [][] colorArr = new int [N][3];
		int [][] minCostArr = new int [N][3];
		scan.nextLine();
		
		for(int i=0; i<N; i++) {
			String [] costs = scan.nextLine().split(" ");
			int [] costArr = Arrays.stream(costs).mapToInt(Integer::parseInt).toArray();
			colorArr[i][0] = costArr[0]; // 0이면 빨강, 1이면 초록, 2이면 파랑 
			colorArr[i][1] = costArr[1];
			colorArr[i][2] = costArr[2];
		}
		
		minCostArr[0][0] = colorArr[0][0]; 
		minCostArr[0][1] = colorArr[0][1];
		minCostArr[0][2] = colorArr[0][2];
		
		for(int i=1; i<N; i++) {
			minCostArr[i][0] = colorArr[i][0] + Math.min(minCostArr[i-1][1], minCostArr[i-1][2]);
			minCostArr[i][1] = colorArr[i][1] + Math.min(minCostArr[i-1][0], minCostArr[i-1][2]);
			minCostArr[i][2] = colorArr[i][2] + Math.min(minCostArr[i-1][0], minCostArr[i-1][1]);
					
		}
			
		
		int Min = Math.min(Math.min(minCostArr[N-1][0], minCostArr[N-1][1]), minCostArr[N-1][2]);		
		System.out.println(Min);

	}

}