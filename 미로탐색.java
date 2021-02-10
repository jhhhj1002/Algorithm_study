import java.util.*;

public class Main{
    static int N;
    static int M;
    static int [][] matrix;
    
    
    public static void main(String []args){

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        matrix = new int [N][N];
        boolean [][] visited = new boolean[N][M];
        int [][] answer = new int [N][M];
        scan.nextLine();
        
        for(int i=0; i<N; i++){ // matrix 값 설정
            String [] temp1 = scan.nextLine().split("");
            int [] temp2 = Arrays.stream(temp1).mapToInt(Integer::parseInt).toArray();
            matrix[i] = temp2;
        }
        
        
        bfs(0,0,visited,answer);
        
        System.out.println(answer[N-1][M-1]);
    }
    
    public static void bfs(int x, int y,boolean [][] visited,int [][] answer){
    	
    	Queue <Location> queue = new LinkedList<>();
    	int [] xArr = {-1,0,1,0};
    	int [] yArr = {0,1,0,-1};
    	
    	queue.add(new Location(x,y));
    	visited[x][y] = true;
    	answer[x][y] = 1;
    	
    	while(!queue.isEmpty()) {
    		
    		Location location = queue.poll();
    		int xIndex = location.x;
    		int yIndex = location.y;
    		
    		for(int i=0; i<4; i++) {
    			int xnew = xIndex+xArr[i];
    			int ynew = yIndex+yArr[i];
    			if(validCheck(xnew,ynew,visited)) {
    				visited[xnew][ynew] = true;
    				answer[xnew][ynew] = answer[xIndex][yIndex]+1;
    				queue.add(new Location(xnew,ynew));
    			}
    		}
    	}
    }
    
    
    public static boolean validCheck(int x,int y,boolean [][] visited) {
    	if( x < 0 || x > N-1 || y < 0 || y > M-1)
    		return false;
    	else if(visited[x][y] == true || matrix[x][y] !=1)
    		return false;
    	return true;
    }
    

}

class Location{
	int x,y;
	public Location(int x,int y) {
		this.x = x;
		this.y = y;
	}
}