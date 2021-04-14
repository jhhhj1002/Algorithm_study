package baekjoon_Algorithm;

import java.util.*;
import java.io.*;

public class baekjoon_14889 {

	static int N;
	static int[][] matrix;
	static int min = 987654321;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			String[] strArr = s.split(" ");
			matrix[i] = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
		}

		ArrayList<Integer> arr = new ArrayList<>();

		solution(arr, 0);
		System.out.println(min);

	}

	public static void solution(ArrayList<Integer> arr, int index) { // visited 대신 ArrayList 사용

		if (arr.size() == (N / 2)) {
			min = Math.min(min, calculate(arr));
			return;
		}
		
		for (int i = index; i < N; i++) {
			arr.add(i);
			solution(arr, i + 1);
			arr.remove(arr.indexOf(i));
		}

	}

	public static int calculate(ArrayList<Integer> arr) { 
		int sum = 0;
		int sum2 = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!arr.contains(i) && !arr.contains(j)) { // 이부분에서 이중반복문 안에서 또, ArrayList.contains를 반복하며 시간소요가 커진 듯
					sum += matrix[i][j];
				}
				else if(arr.contains(i) && arr.contains(j)) { // 이부분에서 이중반복문 안에서 또, ArrayList.contains를 반복하며 시간소요가 커진 듯
					sum2 += matrix[i][j];
				}
			}

		}
		return Math.abs(sum2-sum);

	}

}