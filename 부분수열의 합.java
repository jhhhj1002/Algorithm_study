import java.util.*;


public class Main {
	
	static int N,S;
	static int count = 0;
	static int [] list;

	public static void main(String[] args) { // 합이 S가 되는 부분수열의 개수 구하기
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		S = scan.nextInt();
		
		list = new int [N];
		
		for(int i=0; i<N; i++) {
			list[i] = scan.nextInt();
		}
		
		solution(0,0);
		
		System.out.println(count);
	}
	
	public static void solution(int index,int sum) {

		if(sum == S && index!=0) {
			count ++;
		}
		for(int i=index; i<N; i++) {
			int temp = sum + list[i];
			solution(i+1,temp);
		}
		
	}

}
