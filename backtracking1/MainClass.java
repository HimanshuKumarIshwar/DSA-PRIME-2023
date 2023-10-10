package backtracking1;

public class MainClass {
    public static void main(String[] args) {
        int [][]mat ={{1,1,1,0},
                {1,0,0,1},
                {1,1,0,0},
                {1,1,1,1}};
        int n =mat.length;
        int m =mat[0].length;
        boolean [][]visit =new boolean[n][m];
        visit[0][0] =true;
        ratInMaze(mat,0,0,n,m,visit,"");

    }
    static void ratInMaze(int[][]mat,int i,int j,int n,int m,boolean [][]visit,String path){
        if(i==n-1 && j==m-1){
            System.out.println(path);
            return;
        }

        if(isValid(mat,n,m,i+1,j,visit)){ //D
            visit[i+1][j] =true;
            ratInMaze(mat,i+1,j,n,m,visit,path+"D");
            visit[i+1][j] =false;
        }
        if(isValid(mat,n,m,i,j-1,visit)){ //L
            visit[i][j-1] =true;
            ratInMaze(mat,i,j-1,n,m,visit,path+"L");
            visit[i][j-1] =false;
        }
        if(isValid(mat,n,m,i,j+1,visit)){ //R
            visit[i][j+1] =true;
            ratInMaze(mat,i,j+1,n,m,visit,path+"R");
            visit[i][j+1] =false;
        }
        if(isValid(mat,n,m,i-1,j,visit)){ //U
            visit[i-1][j] =true;
            ratInMaze(mat,i-1,j,n,m,visit,path+"D");
            visit[i-1][j] =false;
        }



    }
    static boolean isValid(int mat[][],int n,int m,int i,int j,boolean [][]visit){

        return i < n && i >= 0 && j < n && j >= 0 && mat[i][j] == 1 && !visit[i][j];
    }
}
