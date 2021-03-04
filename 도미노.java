import java.util.*;

public class Main {

    static ArrayList<Integer> [] array;
    static ArrayList<Integer> [] sccGroup;
    static int [] order;
    static int num,size;
    static Stack <Integer> stack = new Stack<>();
    static boolean [] visited;
    static int [] mySccGroup;

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        int caseSize = scan.nextInt();


        for(int i=0; i<caseSize; i++){
            int N = scan.nextInt();
            int M = scan.nextInt();
            array = new ArrayList [N+1];
            sccGroup = new ArrayList [N+1];

            for(int j=0; j<N+1; j++){
                array[j] = new ArrayList<>();
                sccGroup[j] = new ArrayList<>();
            }


            for(int j=0; j<M; j++){
                int startIndex = scan.nextInt();
                int endIndex = scan.nextInt();
                array[startIndex].add(endIndex);
            }

            mySccGroup = new int [N+1];
            order = new int [N+1];
            visited = new boolean[N+1];


            size = num = 0;

            for(int j=1; j<N+1; j++){
                if(order[j] == 0){
                    SCC(j);
                }
            }


            boolean [] indegree = new boolean[size]; // sccGroup의 indegree 확인하는 배열
            for(int j=1; j<N+1; j++){
                for(int k=0; k<array[j].size(); k++){
                    int endNode = array[j].get(k);

                    if(mySccGroup[endNode] != mySccGroup[j])
                        indegree[mySccGroup[endNode]] = true;
                }
            }

            int count = 0;
            for(int j=0; j<size; j++){
                if(!indegree[j])
                    count ++;
            }

            System.out.println(count);
        }
    }

    public static int SCC(int index){
        order[index] = ++num;

        stack.add(index);

        int parent = order[index];

        for(int i=0; i<array[index].size(); i++){
            int temp = array[index].get(i);

            if(order[temp] == 0){
                parent = Math.min(parent,SCC(temp));
            }
            else if(!visited[temp]){
                parent = Math.min(parent,order[temp]);
            }
        }

        if(parent == order[index]){
            while(true){

                int top = stack.pop();
                visited[top] = true;
                sccGroup[size].add(top);
                mySccGroup[top] = size;

                if(top == index)
                    break;
            }

            size++;
        }

        return parent;
    }
}
