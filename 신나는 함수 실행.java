package baekjoon_Algorithm;

import java.util.*;

public class baekjoon_9184 {
	
	static int [][][] arr = new int [51][51][51];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		String [] str = scan.nextLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		int c = Integer.parseInt(str[2]);
		
		arr[0][0][0] = 1;
		for(int i=0; i<=20; i++) {
			for(int j=0; j<=20; j++) {
				arr[0][i][j] = 1;
				arr[i][0][j] = 1;
				arr[i][j][0] = 1;
			}
		}
		
		
		for(int i=1; i<=20; i++) {
			for(int j=1; j<=20; j++) {
				for(int k=1; k<=20; k++) {
					if(i < j && j < k) {
						arr[i][j][k] = arr[i][j][k-1] + arr[i][j-1][k-1] - arr[i][j-1][k];
					}
					arr[i][j][k] = arr[i-1][j][k] + arr[i-1][j-1][k] + arr[i-1][j][k-1] - arr[i-1][j-1][k-1];
				}
			}
		}
		
		
		
		while(!(a == -1 && b == -1 && c == -1)) {
			
			int num = 0;
			
			if( a <= 0 || b <= 0 || c <= 0 )
				num = 1;
			else if( a > 20 || b > 20 || c > 20 )
				num = arr[20][20][20];
			else
				num = arr[a][b][c];
			
			System.out.println("w("+a+", "+b+", "+c+") = " + num);
			
			str = scan.nextLine().split(" ");
			a = Integer.parseInt(str[0]);
			b = Integer.parseInt(str[1]);
			c = Integer.parseInt(str[2]);
			
		}

	}

}
