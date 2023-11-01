package backtracking2;

public class MainClass {
    public static void main(String[] args) {
      int []a ={1,2,3};
      permute(a,0,a.length-1);
    }
    static void permute(int []a, int l, int r){
        if(l==r){
            printArray(a);
            return;
        }
        for(int i=l; i<=r; i++){
            swap(a,i,l);
            permute(a,l+1,r);
            swap(a,i,l);
        }
    }
    static void printArray(int []a){
        for(int e: a){
            System.out.print(e+" ");
        }
        System.out.println();
    }
    static void swap(int []a, int i,int j){
        int temp =a[i];
        a[i] =a[j];
        a[j] =temp;
    }

    public static class GenerateParentheses {
        public static void main(String[] args) {
            generateParent(2,0,0,0,"");
        }
        static void generateParent(int n, int open, int close, int i, String cur){
            if(i==2*n){
                System.out.println(cur);
                return;
            }

            if(open<n){
                cur+='(';
                generateParent(n,open+1,close,i+1,cur);
                cur =cur.substring(0,cur.length()-1);
            }
            if(close<open){
                cur+=')';
                generateParent(n,open,close+1,i+1,cur);
               // cur=cur.substring(0,cur.length()-1); not use again
            }
        }
    }
}
