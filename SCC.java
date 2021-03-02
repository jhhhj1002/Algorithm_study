import java.util.*;

public class beakjoon_2150 {
    static int V, E;
    static ArrayList<Integer> [] linked,answer;
    static int [] order;
    static boolean [] visited;
    static int size,num;
    static Stack <Integer> stack;

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        V = scan.nextInt();
        E = scan.nextInt();

        linked = new ArrayList[V+1];
        answer = new ArrayList[V+1];

        for(int i=0; i<V+1; i++){
            linked[i] = new ArrayList<>();
            answer[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            int A = scan.nextInt();
            int B = scan.nextInt();
            linked[A].add(B);
        }

        order = new int[V+1];
        visited = new boolean[V+1];
        size = 0;
        num = 0;

        stack = new Stack<>();

        for(int i=1; i<V+1; i++){
            if(order[i]==0)
                SCC(i);
        }

        System.out.println(size);

        for(int i=1; i<V+1; i++){
            if(answer[i].size() > 0){
                for(int j=0; j<answer[i].size(); j++){
                    System.out.print(answer[i].get(j) + " ");
                }
                System.out.print("-1");
                System.out.println( );
            }
        }

    }

    public static int SCC(int index){

        order[index] = ++num;

        stack.add(index);
        int root = order[index];

        for(int i=0; i<linked[index].size(); i++){
            int temp = linked[index].get(i);
            if(order[temp] == 0)
                root = Math.min(root, SCC(temp));
            else if(!visited[temp])
                root = Math.min(root, order[temp]);
        }

        if(root == order[index]){

            ArrayList<Integer> tempArr = new ArrayList<>();
            while(true){
                int top = stack.pop();
                tempArr.add(top);
                visited[top] = true;
                if(top == index) break;
            }
            Collections.sort(tempArr);
            int min = Collections.min(tempArr);
            answer[min] = tempArr;
            size++;
        }

        return root;
    }

}



