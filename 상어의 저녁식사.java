import java.util.*;

public class beakjoon_1671 {

    static int N;
    static int [] occuppied;
    static boolean [] isMatched;
    static Shark [] sharks;

    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        occuppied = new int [N+1];
        isMatched = new boolean [N+1];
        sharks = new Shark[N+1];


        for(int i=1; i<N+1; i++){
            int size = sc.nextInt();
            int velocity = sc.nextInt();
            int intelligence = sc.nextInt();
            sharks[i] = new Shark(size,velocity,intelligence);
        }


        int count = 0;

        for(int i=1; i<N+1; i++){
            isMatched = new boolean [N+1];
            if(dfs(sharks[i], i))
                count++;
        }

        for(int i=1; i<N+1; i++){
            isMatched = new boolean [N+1];
            if(dfs(sharks[i], i))
                count++;
        }

        int answer = N-count;

        System.out.println(answer);

    }

    public static boolean dfs(Shark shark,int index){

        for(int i=1; i<N+1; i++){

            if(i!=index){

                if(isMatched[i])
                    continue;

                int compare = shark.compareTo(sharks[i]);

                if((compare == 0 && index > i ) || compare == 1 ) {
                    isMatched[i] = true;
                    if(occuppied[i] == 0 || dfs(sharks[occuppied[i]],occuppied[i])){
                        occuppied[i] = index;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


class Shark implements Comparable<Shark>{
    int size;
    int velocity;
    int intelligence;

    public Shark(int size, int velocity, int intelligence){
        this.size = size;
        this.velocity = velocity;
        this.intelligence = intelligence;
    }

    @Override
    public int compareTo(Shark shark){
        if(this.size == shark.size && this.velocity == shark.velocity && this.intelligence == shark.intelligence)
            return 0;
        else if(this.size >= shark.size && this.velocity >= shark.velocity && this.intelligence >= shark.intelligence)
            return 1;
        else
            return -1;
    }
    
}