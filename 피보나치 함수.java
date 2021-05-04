

import java.util.Scanner;

public class baekjoon_1003{
    static countOfNum[] arr = new countOfNum [41];
    
    public static void main(String[]args){ // 0이 출력되는 횟수와 , 1이 출력되는 횟수 반환
    
        Scanner scan = new Scanner(System.in);
        int time = scan.nextInt();
        
        arr[0] = new countOfNum(1,0);
        arr[1] = new countOfNum(0,1);
        
        for(int i=2; i<=40; i++) {
        	arr[i] = new countOfNum(arr[i-1].zeroCount + arr[i-2].zeroCount, arr[i-1].oneCount + arr[i-2].oneCount);
        }
        
    
        for(int i=0; i<time; i++){
            int num = scan.nextInt();
            System.out.print(arr[num].zeroCount + " ");
            System.out.println(arr[num].oneCount);
        }
    }
    
}

class countOfNum{
	int zeroCount = 0;
	int oneCount = 0;
	
	public countOfNum(int zeroCount, int oneCount) {
		this.zeroCount = zeroCount;
		this.oneCount = oneCount;
	}
}