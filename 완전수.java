package baekjoon_Algorithm;
import java.util.*;

public class baekjoon_14563 {
	
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		
		scan.nextLine();
		int [] numArr = Arrays.asList(scan.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		
		for(int num : numArr) {
			int result = solution(num);
			
			if(num > result)
				System.out.println("Deficient");
			else if(num == result)
				System.out.println("Perfect");
			else
				System.out.println("Abundant");
		}
		
		
	}
	
	public static int solution(int num) {
		int sum = 0;
		for(int i=1; i<num; i++) {
			if(num%i == 0)
				sum += i;
		}
		return sum;
	}

}
