import java.util.*;

public class baekjoon_10814 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		ArrayList <String> [] strArr = new ArrayList[201];
		
		for(int i=1; i<=200; i++) {
			strArr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<num; i++) {
			int age = scan.nextInt();
			String name = scan.nextLine();
			strArr[age].add(name);
		}
		
		for(int i=1; i<201; i++) {
			if(strArr[i].size() > 0) {
				for(int j=0; j<strArr[i].size(); j++) {
					System.out.println(i + "" + strArr[i].get(j));
				}
			}			
		}
		
	}
}
