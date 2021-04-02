import java.util.*;

public class baekjoon_1181 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		String [] str = new String[num];
		
		ArrayList <String> [] strLength = new ArrayList[51];
		
		for(int i=0; i<=50; i++) {
			strLength[i] = new ArrayList<>();
		}
		
		for(int i=0; i<num; i++) {
			String s = scan.next();
			int len = s.length();
			
			if(!strLength[len].contains(s)) {
				strLength[len].add(s);
			}
		}
		
		for(int i=0; i<=50; i++) {
			if(strLength[i].size() == 1) {
				System.out.println(strLength[i].get(0));
			}else if(strLength[i].size()>1) {
				
				Collections.sort(strLength[i]);
				
				for(String st : strLength[i]) {
					System.out.println(st);
				}
			}
		}
	}
}
