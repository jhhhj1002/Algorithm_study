package baekjoon_Algorithm;

import java.util.*;

public class baekjoon_14888 {
	
	static int N;
	static int [] numArr;
	static String [] symbol;
	static ArrayList <Integer> resultArr = new ArrayList <>();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		numArr = new int [N];
		symbol = new String [N-1];
		
		for(int i=0; i<N; i++) {
			numArr[i] = scan.nextInt();
		}
		
		int size = 0;
		String [] str = {"+","-","*","/"};
		
		for(int i=0; i<4; i++) {
			int count = scan.nextInt();
			for(int j=0; j<count; j++) {
				symbol[size + j] = str[i];
			}
			size = size + count;
		}
		
		ArrayList <Integer> tempArr = new ArrayList <>();

		solution(1,numArr[0],tempArr);
		
		System.out.println(Collections.max(resultArr));
		System.out.println(Collections.min(resultArr));

	}
	
	public static void solution(int depth, int sum, ArrayList <Integer> tempArr) { // depth == numArr 의 index

		if(depth == N) {
			resultArr.add(sum);
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			
			if(!tempArr.contains(i)) {	
				tempArr.add(i);
				String s = symbol[i];
				int sumTemp = 0;
				
				if(s.equals("+")) {
					sumTemp = sum + numArr[depth];
				}else if(s.equals("-")) {
					sumTemp = sum - numArr[depth];					
				}else if(s.equals("*")) {
					sumTemp = sum * numArr[depth];
					
				}else if(s.equals("/")) {
					sumTemp = sum / numArr[depth];
				}
				solution(depth+1, sumTemp, tempArr);
				tempArr.remove(tempArr.indexOf(i));
			}
		}
		
	}

}
