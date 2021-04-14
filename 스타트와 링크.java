package baekjoon_Algorithm;

import java.util.*;
import java.io.*;

public class baekjoon_14889_2 {

	static int N;
	static int[][] matrix;
	static int min = 987654321;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			String[] strArr = s.split(" ");
			matrix[i] = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
		}

		solution(0, 0);
		System.out.println(min);

	}

	public static void solution(int index, int depth) {

		if (depth == (N / 2)) {
			min = Math.min(min, calculate());
			return;
		}

		for (int i = index; i < N; i++) {
			visited[i] = true;
			solution(i + 1, depth + 1);
			visited[i] = false;
		}
	}

	
	public static int calculate() { 
		int sum = 0;
		int sum2 = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i] && !visited[j]) {
					sum += matrix[i][j];
				} else if (visited[i] && visited[j]) {
					sum2 += matrix[i][j];
				}
			}
		}
		return Math.abs(sum2 - sum);
	}

}