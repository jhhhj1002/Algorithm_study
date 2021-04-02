import java.util.*;

public class Main {
	
	static ArrayList <Integer> arr;
	static int answer = 0;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		arr = new ArrayList<>();
		
		for(int i=2; i<N+1; i++) {
			arr.add(i);
		}
		
		solution(K);
		System.out.println(answer);

	}
	
	
	public static void solution(int index) {
        
		int count = 0;
		boolean flag = false;
		
			while(!arr.isEmpty() && !flag) {
				
				int num = arr.get(0);
				arr.remove(0);
				count ++;
                
				if(count == index) {
					answer = num;
					break;
				}
				
				for(int i=0; i<arr.size(); i++) { // arr.size 동적으로 줄어드는 것도 생각
					int temp = arr.get(i);
					
					if(temp%num == 0) { 
						arr.remove(i);
						count++;
						i--; // remove하면 i 다시 감소시켜야함
						
						if(count == index) {
							answer = temp;
							flag = true;
							break;
						}
					}				
				}
			}	
	   }
}
