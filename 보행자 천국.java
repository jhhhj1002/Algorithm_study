class Solution {
    int MOD = 20170805;
    Element [][] matrix;

    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        matrix = new Element [m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = new Element(0,0);
            }
        }

        matrix[0][0] = new Element(1,1);

        for(int x=0; x<m; x++){
            for(int y=0; y<n; y++){
                if(y+1 < n && cityMap[x][y+1] != 1){
                    if(cityMap[x][y] == 0 ){
                        if(x==0 && y==0){
                            matrix[x][y+1].left += 1;
                        }else {
                            matrix[x][y+1].left +=  matrix[x][y].left +  matrix[x][y].top;
                        }
                    }else if(cityMap[x][y] == 2 ){
                        matrix[x][y+1].left +=  matrix[x][y].left ;
                    }
                    matrix[x][y+1].left%= MOD;

                }
                if(x+1 < m && cityMap[x+1][y] != 1){

                    if(cityMap[x][y] == 0 ){ // 아래
                        if(x==0 && y==0){
                            matrix[x+1][y].top += 1;
                        }else {
                            matrix[x+1][y].top +=  matrix[x][y].left +  matrix[x][y].top ;
                        }
                    }else if(cityMap[x][y] == 2){
                        matrix[x+1][y].top += matrix[x][y].top %= MOD;
                    }
                    matrix[x+1][y].top%= MOD;
                }

            }
        }

        answer = (matrix[m-1][n-1].left +  matrix[m-1][n-1].top) % MOD;
        // System.out.println("answer : " + answer );
        return answer;
    }

}

class Element {
    int left;
    int top;

    Element(int left, int top){
        this.left = left;
        this.top = top;
    }
}