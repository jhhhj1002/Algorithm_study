package baekjoon;

import java.util.*;

public class baekjoon_7568 {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		Person [] person = new Person [N];
		
		for(int i=0; i<N; i++) {
			int w = scan.nextInt();
			int h = scan.nextInt();
			person[i] = new Person(w,h);
		}
		
		for(int i=0; i<N; i++) {
			Person p = person[i];
			for(int j=0; j<N; j++) {
				Person q = person[j];
				
				if( j!=i && p.weight < q.weight && p.height < q.height) {
					p.grade ++;
				}
			}
		}
		
		for( Person p : person ) {
			System.out.print(p.grade + " ");
		}
		
		
	}

}

class Person{
	int weight;
	int height;
	int grade;
	
	public Person(int weight, int height) {
		this.weight = weight;
		this.height = height;
		this.grade = 1;
	}
}
