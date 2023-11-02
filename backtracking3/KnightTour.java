package backtracking3;

public class KnightTour {

    public static void main(String[] args) {
        int n =5;
     int [][]a=knightTour(n);
     for(int i=0; i<n; i++){
         for(int j=0; j<n; j++){
             System.out.print(a[i][j]+" ");
         }
         System.out.println();
     }

    }
    static int [][] knightTour(int n){
        int [][]a =new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j] =-1;
            }
        }
        a[0][0] =0;
        int []movesX ={2,1,-1,-2,-2,-1,1,2};
        int []movesY ={1,2,2,1,-1,-2,-2,-1};
        knightTourHelper(n,a,movesX,movesY,0,0,1);


        return a;


    }
    static boolean knightTourHelper(int n, int [][]a, int [] movesX, int[] movesY,int curX,int curY, int step){
        if(step==n*n)return true;

        for(int i=0; i<8; i++) {
            int nextX = curX+movesX[i];
            int nextY = curY+movesY[i];
            if(isSafe(n,a,nextX,nextY)){
                a[nextX][nextY] =step;
                if(knightTourHelper(n,a,movesX,movesY,nextX,nextY,step+1)) {
                    return true;
                }else {
                    a[nextX][nextY] =-1;
                }

            }



        }

        return false;
    }


    static boolean isSafe(int n, int[][]a,int x,int y){
        return x >= 0 && y >= 0 && x < n && y < n && a[x][y] == -1;
    }
}
