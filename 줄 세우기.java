import java.util.*;

public class Main{
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        ArrayList <Integer> [] arraylist = new ArrayList[N+1];
        int parents [] = new int [N+1];
        boolean flag [] = new boolean [N+1];

        for(int i=1; i<N+1; i++){
            parents[i] = 0;
            arraylist[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            arraylist[num1].add(num2);
            parents[num2] += 1;
        }

        Queue <Integer> queue = new LinkedList<>();
        ArrayList <Integer> result = new ArrayList<>();

        for(int i=1; i<N+1; i++){
            if(parents[i] == 0) {
                queue.add(i);
                flag[i] = true;
            }
        }

       while(!queue.isEmpty()){
            int top = queue.poll();
            result.add(top);
            for(int i=0; i<arraylist[top].size(); i++){
                int temp = arraylist[top].get(i);
                parents[temp] -= 1;

                if(parents[temp] == 0 && flag[temp] == false) {
                    queue.add(temp);
                    flag[temp] = true;
                }
            }
        }

        for(Integer k : result){
            System.out.print(k + " ");
        }

    }
}