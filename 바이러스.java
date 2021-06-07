package baekjoon_Algorithm;
import java.util.*;

public class beakjoon_2606 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		int N = scan.nextInt();
		boolean [] isvisited = new boolean[N+1];
		ArrayList<Integer>[] arrayList = new ArrayList[N+1]; // index 1부터 시작 
		
		for(int i=1; i<N+1; i++) {
			arrayList[i] = new ArrayList<>();
		}
		
		int count = scan.nextInt();
		scan.nextLine();
		
		for(int i=0; i<count; i++) {
			String [] str = scan.nextLine().split(" ");
			int [] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
			
			arrayList[arr[0]].add(arr[1]);
			arrayList[arr[1]].add(arr[0]);
		}
		
		int answer = -1;
		Queue <Integer> queue = new LinkedList<>();
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int num = queue.remove();
			if(!isvisited[num]) {
				isvisited[num] = true;
				answer++;
				
				for(int i=0; i<arrayList[num].size(); i++) {
					int n = arrayList[num].get(i);
					if(!isvisited[n])
						queue.add(n);
				}
			}
			
		}
		
		System.out.println(answer);

	}

}
