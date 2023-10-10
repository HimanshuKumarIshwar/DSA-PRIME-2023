package stack5;
import java.util.*;
public class MainClass {
    public static void main(String[] args) {
//        int []a ={1,6,4,10,2,5};
//        int []ans =previousSmaller(a);
//        for(int e:ans){
//            System.out.print(e+" ");
//        }
//        int []a ={1,6,4,10,2,4};
//        int []ans =nextSmallest(a);
//        for(int e:ans){
//            System.out.print(e+" ");
//       }


        int a[] ={1,4,3,2,7,9,6,4};
        int []ans =maxOfMinOfEveryWindow(a);
        for(int e: ans){
            System.out.print(e+" ");
        }


    }

    static int[] maxOfMinOfEveryWindow(int []a){
        int n =a.length;
        int []leftMin =previousSmaller(a);
        int []rightMin =nextSmallest(a);
        int []ans =new int[n];
        Arrays.fill(ans,Integer.MIN_VALUE);

       for(int i=0; i<a.length; i++) {
           int winLen =rightMin[i]-leftMin[i]-1;
           ans[winLen-1] =Math.max(ans[i],a[i]);

       }

       for(int i=n-2; i>=0; i--){
           ans[i] =Math.max(ans[i],ans[i+1]);
       }




        return ans;
    }

    static int[] nextSmallest(int []a){
        int n =a.length;
        int []ans =new int[n];

        ArrayDeque<Integer> stack =new ArrayDeque<>();

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && a[stack.peek()]>=a[i]){
                stack.pop();

            }
            if(stack.isEmpty()){
                ans[i] =n;
            }else{
                ans[i] =stack.peek();
            }
            stack.push(i);
        }
        return ans;

    }
    static int[] previousSmaller(int []a){
        int n =a.length;
        int []ans =new int[n];
        ArrayDeque<Integer> stack =new ArrayDeque<>();


          for(int i=0; i<n; i++){
              while(!stack.isEmpty() && a[stack.peek()]>=a[i]){
                  stack.pop();
              }
              if(stack.isEmpty()){
                  ans[i] =-1;
              }else{
                  ans[i] =stack.peek();
              }
              stack.push(i);
          }


        return ans;
    }
}
