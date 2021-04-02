package baekjoon;

import java.util.*;

public class baekjoon_1193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		int count = 1;
		int sum = 1;
		count ++;
		
		while(num >= sum + count ) {
			sum += count;
			count ++;
		}
		
		int rest = num - sum;
		
		if(rest == 0) {
			int a = 1;
			int b = --count;
			if(count%2 ==1) {
				System.out.println(a+"/"+b);
			}else {
				System.out.println(b+"/"+a);
			}

		}else {
			int a = count;
			int b = 1;
			
			for(int i=1; i<rest; i++) {
				a--;
				b ++;
			}
			
			if(count %2 ==1) {
				System.out.println(a+"/"+b);
			}else {
				System.out.println(b+"/"+a);
			}

		}		

	}

}
