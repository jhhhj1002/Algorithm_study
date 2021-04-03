package baekjoon_Algorithm;
import java.util.*;
import java.io.*;

public class baekjoon_15651 {
	
	static int[] arr;
	static int N, M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		N = Integer.parseInt(s.split(" ")[0]);
		M = Integer.parseInt(s.split(" ")[1]);

		arr = new int[M];
		solution(0);
		bw.close();
    
	}

	public static void solution(int index) throws IOException{

		if (index == M) {
			for (int s : arr) {
				bw.write(s + " ");
			}
			bw.newLine();

		} else {
			for (int i = 1; i <= N; i++) {
				arr[index] = i;
				solution(index + 1);
		
			}
		}

	}

}

