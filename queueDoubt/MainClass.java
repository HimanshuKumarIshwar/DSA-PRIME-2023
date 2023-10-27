package queueDoubt;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MainClass {
    public static void main(String[] args) {
//   int []a ={0,0,0,1,0,1,1,0};
//   int k=3;
//        System.out.println(bitsFlips(a,k));


        int []a ={5,4,2,4};
        System.out.println(continuousSubArray(a));
    }

    static int continuousSubArray(int []a){
        int count =0;
        int n =a.length;
        int l=0;
        ArrayDeque<Integer> min =new ArrayDeque<>();
        ArrayDeque<Integer> max =new ArrayDeque<>();
        for(int r =0; r<n; r++){
            while(!min.isEmpty() && min.getLast()>a[r]){
                min.pollLast();
            }
            min.offerLast(a[r]);

            while(!max.isEmpty() && max.getLast()<a[r]){
                max.pollLast();
            }
            max.offerLast(a[r]);


             while(max.getFirst()-min.getFirst()>2) {
                 if(max.getFirst()==a[l]){
                     max.pollFirst();
                 }
                 if(min.getFirst()==a[l]){
                     min.pollFirst();
                 }
                 l++;
             }

             count+=(r-l+1);




        }
        return count;
    }
    static int bitsFlips(int []a, int k){
        int n =a.length;
        int count =0;
        Queue<Integer> q =new LinkedList<>();

        for(int i=0; i<n; i++){
            if((q.size()&1)!=0){
                a[i]=a[i]^1;
            }
            if(a[i]==0){
                if(i+k>n)return -1;
                count++;
                q.offer(i+k-1);
            }
           if(!q.isEmpty()&& q.peek()==i) {
               q.poll();
           }
        }
        return count;

    }
}
