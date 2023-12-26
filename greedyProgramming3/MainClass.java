package greedyProgramming3;

import java.util.Arrays;
import java.util.Collections;

public class MainClass {


    public static void main(String[] args) {
//int a[] ={3,1,4,2,1,3};
//        System.out.println(minimumCandies(a));


        Integer h[] ={4,1,2};
        Integer v[] ={2,1,3,1,4};
        System.out.println(minCostToCurtBoard(h,v));

    }

    static int minCostToCurtBoard(Integer  []h, Integer []v){
        Arrays.sort(h, Collections.reverseOrder());
        int n =v.length;
        int m =h.length;
        Arrays.sort(v,Collections.reverseOrder());
        int hsq =1;
        int vsq =1;

        int i=0, j=0;
        int cost=0;

       while(i<n && j<m){
           if(v[i]<h[j]){
               cost+=h[j]*vsq;
               hsq++;
               j++;
           }else{
               cost+=v[i]*hsq;
               vsq++;
               i++;
           }
       }

       while(i<n){
           cost+=v[i]*hsq;
           i++;
       }
       while(j<m){
           cost+=h[j]*vsq;
           j++;
       }

       return cost;
    }

    static int minimumCandies(int a[]){
        int n =a.length;
        int [] candies =new int[n];
        Arrays.fill(candies,1);

        // L to right path1
        for(int i=1; i<n; i++){
            if(a[i]> a[i-1]){
                candies[i] =candies[i-1]+1;
            }
        }


        // R to L

        for(int i =n-2; i>=0; i--){
            if(a[i]>a[i+1] && candies[i]<=candies[i+1]){
                candies[i] =candies[i+1]+1;
            }
        }


        int max =0;
        for(int e: candies){
            max += e;
        }
        return max;
    }
}
