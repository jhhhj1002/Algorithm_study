import java.util.*;

public class Main{
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList <Integer> [] arraylist = new ArrayList[N+1];
        int parents [] = new int [N+1];
        boolean flag [] = new boolean [N+1];
        int time [] = new int [N+1];
        int result [] = new int [N+1];

        for(int i=0; i<N+1; i++){
            arraylist[i] = new ArrayList<>();
        }

        for(int i=1; i<N+1; i++){
            int t = scan.nextInt();
            time[i] = result[i] = t;
            int temp = scan.nextInt();
            while(temp != -1){
                parents[i]++;
                arraylist[temp].add(i);
                temp = scan.nextInt();
            }
        }

        Queue <Integer> queue = new LinkedList<>();

        for(int i=1; i<N+1; i++){
            if(parents[i] == 0) {
                queue.add(i);
                flag[i] = true;
            }
        }

        while(!queue.isEmpty()){
            int top = queue.poll();

            for(int i=0; i<arraylist[top].size(); i++){
                int temp = arraylist[top].get(i);
                parents[temp] --;
                result[temp] = (result[temp] > time[temp] + result[top]) ? result[temp] : time[temp] + result[top];


                if(parents[temp] == 0 && flag[temp] == false) {
                    queue.add(temp);
                    flag[temp] = true;
                }
            }
        }

        for(int i=1; i<N+1; i++){

            System.out.println(result[i]);
        }

    }
}