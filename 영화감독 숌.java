import java.util.*;

public class baekjoon_1436 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int count = 1;
		int num = 666;
		
		while(count != N) {
			
			num ++;
			
			String str = Integer.toString(num);
			if(str.contains("666")) {
				count ++;
			}
			
		}
		
		System.out.print(num);
		
	}

}
