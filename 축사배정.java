import java.util.*;

public class CattleShed {

    static ArrayList<Integer> [] array;
    static int N,M;
    static boolean [] visited;
    static int [] cattleShed;

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt(); // 소의 개수
        M = scan.nextInt(); // 축사의 개수

        // 모든 배열에 0은 없다고 가정 -> 1부터 시작
        array = new ArrayList[N+1]; // 각각의 소들이 원하는 축사를 담는 배열
        cattleShed = new int [M+1]; // 각 축사에 있는 소
        visited = new boolean [M+1]; // 각 축사가 점유되어있는지 표시

        for(int i=0; i<N+1; i++){
            array[i] = new ArrayList<>();
        }

        for(int i=1; i<N+1; i++){
            int num = scan.nextInt();
            for(int j=0; j<num; j++){
                int temp = scan.nextInt();
                array[i].add(temp);
            }
        }

        int count = 0;

        for(int i=1; i<N+1; i++ ){
            visited = new boolean [M+1]; // 방문 초기화
            if(dfs(i))
                count ++ ;
        }

        System.out.println(count);

    }

    public static boolean dfs(int index){

        for(int i=0; i<array[index].size(); i++){
            int shed = array[index].get(i);

            if(visited[shed])
                continue;
            else
                visited[shed] = true;

            if(cattleShed[shed]==0 || dfs(cattleShed[shed])){
                cattleShed[shed] = index;
                return true;
            }
        }
        return false;
    }
}
