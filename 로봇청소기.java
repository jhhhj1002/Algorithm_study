package baekjoon_Algorithm;

import java.util.*;

public class baekjoon_14503 {
	static int N,M;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		int [][] matrix = new int [N][M]; // 0은 청소안함, 1은 벽, -1은 청소한 것
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		int head = scan.nextInt();
		
		Element element = new Element(x,y,head);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int val = scan.nextInt();
				matrix [i][j] = val;
			}
		}
		
		Stack <Element> stack = new Stack<>();
		stack.push(element);
		int count = 0;
		
		Element [] leftArr = new Element[4];
		leftArr[0] = new Element(0,-1,-1);
		leftArr[1] = new Element(-1,0,-1);
		leftArr[2] = new Element(0,1,-1);
		leftArr[3] = new Element(1,0,-1);
		
		Element []	frontArr = new Element[4];
		frontArr[0] = new Element(-1,0,0);
		frontArr[1] = new Element(0,1,0);
		frontArr[2] = new Element(1,0,0);
		frontArr[3] = new Element(0,-1,0);
		
		Element []	rightArr = new Element[4];
		rightArr[0] = new Element(0,1,1);
		rightArr[1] = new Element(1,0,1);
		rightArr[2] = new Element(0,-1,1);
		rightArr[3] = new Element(-1,0,1);
		
		Element []	backArr = new Element[4];
		backArr[0] = new Element(1,0,0);
		backArr[1] = new Element(0,-1,0);
		backArr[2] = new Element(-1,0,0);
		backArr[3] = new Element(0,1,0);
		
		
		while(!stack.isEmpty()) {
			Element top = stack.pop();
			
			if(matrix[top.x][top.y] == 0) {
				matrix[top.x][top.y] = -1;
				count ++;
			}
			
			Element next = new Element(top.x+leftArr[top.head].x, top.y+leftArr[top.head].y, top.head-1);
			next.head = (next.head<0) ? 3 : next.head;
			
			if(matrix[next.x][next.y] !=0 ) { 
				
				boolean flag = false;
				Element left = next;
				Element right = new Element(top.x+rightArr[top.head].x, top.y+rightArr[top.head].y, top.head+1);
				right.head = (right.head>3) ? 0 : right.head;
				Element front = new Element(top.x+frontArr[top.head].x, top.y+frontArr[top.head].y, top.head);
				Element back = new Element(top.x+backArr[top.head].x, top.y+backArr[top.head].y, top.head + 2);
				back.head = (back.head > 3) ? (back.head-4) : back.head;
				
				if(matrix[left.x][left.y] == 0) {
					stack.push(left);
					flag = true;
				}else if(matrix[back.x][back.y] == 0) {
					stack.push(back);
					flag = true;
				}else if(matrix[right.x][right.y] == 0) {
					stack.push(right);
					flag = true;
				}else if(matrix[front.x][front.y] == 0) {
					stack.push(front);
					flag = true;
				}
				
				if(!flag) {
					if(matrix[back.x][back.y] == -1) {
						back.head = top.head;
						stack.push(back);
					}
					else {
						break;
					}
				}
			
			}else if(matrix[next.x][next.y] == 0) {
				stack.push(next);
			}
		}
		
		System.out.println(count);

	}

}

class Element{
	int x;
	int y;
	int head;
	
	public Element(int x, int y, int head) {
		this.x = x;
		this.y = y;
		this.head = head;
	}
}

