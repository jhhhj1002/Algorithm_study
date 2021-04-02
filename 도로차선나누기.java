import java.util.*;

public class road { // m너비의 도로를 k이하의 자연수 n개로 나누는 방법의 가지수

	public static int [] array;
	public static int m,k,n,count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		m = 9;
		k = 3;
		n = 3;
		count = 0;
		
		array = new int [n];
		
		solution(0,0);
		
		System.out.println(count);

	}
	
	
	public static void solution(int depth, int sum) {
		
		if(depth == n) {
			if(sum == m) {
				count ++;
				for(int k : array) {
					System.out.println(k);
				}
			}
		}
		else {
			for(int i=1; i<k+1; i++) {
				array[depth] = i;
				solution(depth+1,sum + i);
			}
		}
		
	}
}
	