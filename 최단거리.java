import java.util.*;

public class Main{
    
    static int INF = Integer.MAX_VALUE;
     
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt();
        int E = scan.nextInt();
        int start = scan.nextInt();
        scan.nextLine();
        
        int [] distance = new int[V+1];
        
        ArrayList <Element>[] array = new ArrayList[V+1];
        
        for(int i=0; i<V+1; i++){
            distance[i] = INF;
            array[i] = new ArrayList<>();
        }
      
        
        for(int i=0; i<E; i++){
        	String [] temp = scan.nextLine().split(" ");
            int [] arr = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray(); // 외우기
            array[arr[0]].add(new Element(arr[1],arr[2]));
        }
        
        solution(start,distance,array);
        
        for(int i=1; i<V+1; i++){
        	if(distance[i] == INF)
        		 System.out.println("INF");
        	else
        		System.out.println(distance[i]);
        }
        
    }
    
    public static void solution(int start,int [] distance,  ArrayList <Element>[] array){
        PriorityQueue <Element> priorityqueue = new PriorityQueue<>();
        distance[start] = 0;
        priorityqueue.add(new Element(start, distance[start]));
        
        while(!priorityqueue.isEmpty()){
        	Element top = priorityqueue.poll();
            int index = top.index;
            int dis = top.distance;
            
            for(int i=0; i<array[index].size(); i++) {
            	Element temp = array[index].get(i);
            	if( distance[temp.index] > temp.distance + dis) {
            		distance[temp.index] = temp.distance + dis;
            		priorityqueue.add(new Element(temp.index, distance[temp.index]));
            	}
            }
        }

    }   
    
}


class Element implements Comparable <Element>{
	int index;
	int distance;
	
	public Element(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	@Override
	public int compareTo(Element element) {
		if(this.distance < element.distance) return -1;
		else if(this.distance > element.distance) return 1;
		return 0;
	}
}