import java.util.*;

class Solution {
    static int [] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int [n];
        PriorityQueue <Element> priorityqueue = new PriorityQueue <>();
        
        for(int i=0; i<n; i++){
            parent [i] = i;
        }
        
        for(int i=0; i<costs.length; i++){
            priorityqueue.add(new Element(costs[i][0],costs[i][1],costs[i][2]));
        }
        
        while(!priorityqueue.isEmpty()){
            Element element = priorityqueue.poll();
            
            if(findParent(element.startIndex) != findParent(element.endIndex)){ 
                parent[findParent(element.endIndex)] = findParent(element.startIndex);
                answer += element.value;
            }
        }
        
        return answer;
    }
    
    public int findParent(int index){
        if(parent[index] == index)
            return index;
        else
            return findParent(parent[index]);
    }
}

class Element implements Comparable <Element>{
    int startIndex;
    int endIndex;
    int value;
    
    public Element (int x, int y, int value){
        if(x > y){
            this.startIndex = y;
            this.endIndex = x;
        } else{
            this.startIndex = x;
            this.endIndex = y;
        }
        
        this.value = value;
    }
    
    @Override
    public int compareTo(Element element){
        if(this.value < element.value) return -1;
        else if(this.value > element.value) return 1;
        return 0;
    }
}