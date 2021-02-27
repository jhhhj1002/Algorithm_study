import java.util.*;

public class CriticalPath {

    static int N;
    static ArrayList <Elements> [] arraylist;
    static ArrayList <Elements> [] array;
    static int count;

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        int M = scan.nextInt();

        arraylist = new ArrayList [N+1];
        array = new ArrayList [N+1];
        int parents [] = new int [N+1];
        boolean flag [] = new boolean[N+1];

        for(int i=0; i<N+1; i++){
            arraylist[i] = new ArrayList<>();
            array[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            int val = scan.nextInt();
            arraylist[start].add(new Elements(start,end,val));
            array[end].add(new Elements(end,start,val));
            parents[end]++;
        }


        int startIndex = scan.nextInt();
        int endIndex = scan.nextInt();

        int [] distance = solution(startIndex,endIndex,parents,flag);

        System.out.println(distance[endIndex]);
        System.out.println(count);

    }

    public static int[] solution(int start, int end,int parents [], boolean flag [] ){
        Queue <Integer> queue = new LinkedList <>();
        int distance[] = new int [N+1];

        queue.add(start);

        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int i=0; i<arraylist[top].size(); i++){
                Elements temp = arraylist[top].get(i);
                parents[temp.end]--;
                if(parents[temp.end] == 0 && flag[temp.end] == false){
                    queue.add(temp.end);
                    flag[temp.end] = true;
                }
                distance[temp.end] = Math.max(distance[temp.end],(distance[top] + temp.value));
            }


        }

        queue = new LinkedList <>();
        count = 0;

        queue.add(end);
        while (!queue.isEmpty()){
            int top = queue.poll();
            for(int i=0; i<array[top].size(); i++){
                Elements temp = array[top].get(i);
                if(temp.value!=0 && (distance[top]-distance[temp.end])== temp.value){
                    queue.add(temp.end);
                    count ++;
                    temp.value = 0;
                }
            }
        }


        return distance;

    }
}

class Elements {
    int start;
    int end;
    int value;

    public Elements(int start, int end, int value){
        this.start = start;
        this.end = end;
        this.value = value;

    }
}
