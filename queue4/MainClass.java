package queue4;
import java.util.*;
public class MainClass {
   public static void main(String[] args) {
int []a ={12,-1,-7,8,-15,30,16,28};
int k =3;
 int [] ans2 = slidingWindowMax(a,k);
int []ans =firstNegativeEveryWindow(a,k);
for(int e: ans){
    System.out.print(e+" ");
}


   }

//   static int findLastElement(int n, int k){
//       ArrayDeque<Integer> dq =new ArrayDeque<>();
//       for(int i=1; i<=n; i++);
//   }
    static int[] firstNegativeEveryWindow(int []a, int k){
        int n =a.length;
        ArrayDeque<Integer> dq =new ArrayDeque<>();
        int []ans =new int[n-k+1];
        int i=0;
        while(i<k){

           if(a[i]<0){
               dq.offerLast(a[i]);
           }

           i++;
        }

        for(; i<n; i++){

            if(dq.isEmpty()){
              ans[i-k] =0;
            }else{
              ans[i-k] =dq.getFirst();
            }
           if( !dq.isEmpty() && a[i-k]==dq.getFirst()) {
               dq.pollFirst();
           }
           if(a[i]<0) {

               dq.offerLast(a[i]);

           }


            }
        if(dq.isEmpty()){
            ans[i-k] =0;
        }else{

            ans[i-k] = dq.getFirst();
        }
        return ans;

        }




    static int[] slidingWindowMax(int []a, int k){
        int n =a.length;
        ArrayDeque<Integer> dq =new ArrayDeque<>();
        int []ans =new int[n-k+1];

        int i=0;
        while(i<k){
            while(!dq.isEmpty() && dq.getLast()< a[i]){
                dq.pollLast();

            }
            dq.offerLast(a[i]);
            i++;

        }
        for(; i<n; i++){
            ans[i-k] =dq.getFirst();
            if(a[i-k]==dq.getFirst()){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && dq.getLast()< a[i]){
                dq.pollLast();

            }

            dq.offerLast(a[i]);

        }
        ans[i-k] = dq.getFirst();

return ans;
    }
}

