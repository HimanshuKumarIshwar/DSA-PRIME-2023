package greedyProgramingDoubt;
import java.util.*;
public class MainClass {
    public static void main(String[] args) {
//        int a[] ={1,2, 4, 8};
//        System.out.println(maxAbsoluteDiffSumPermutaion(a));



//        int []a = {1,5,10};
//        int n =20;
//        System.out.println(patchingArray(a,n));


    }

    static int patchingArray(int a[], int n){
        Arrays.sort(a);
          int count =0;
          int i =0;
          int reach =0;

          while(reach<n){
              if(i<a.length && reach+1< a[i]){
                  count++;
                  reach+= (reach+1);

              } else if(i< a.length && reach+1 >= a[i]){
                  reach+=a[i];
                  i++;
              }
              else{
                  count++;
                  reach+= (reach+1);
              }
          }
          return count;
    }

    static int maxAbsoluteDiffSumPermutaion(int a[]){
        Arrays.sort(a);
        int l=0;
        int r =a.length-1;

          int sum =0;
          boolean flip =true;
          while(l<r){
               sum+= Math.abs(a[r]-a[l]);
                if(flip){
                    l++;
                }else{
                    r--;
                }
                flip = !flip;
          }

          sum+=Math.abs(a[a.length/2]-a[0]);

        return sum;
    }
}
