package hashing3;
import java.util.*;
public class MainClass {
    public static void main(String[] args) {
       // int[] a = {4, 2, -3, 1,  6};

        //System.out.println(countSubArrayWithZeroSum(a));

//        int [] a ={3,1,2,3};
//        int k=3;
//        System.out.println(countSubArrayWithGivenSum(a,k));



        int a[] ={1, 0, -1, 0, -2, 2};
        System.out.println(subArrayWithQuadrupleGivenSum(a,0));
    }


     static List<List<Integer>> subArrayWithQuadrupleGivenSum(int []a, int k){
        Set<List<Integer>> ans =new HashSet<>();
        int n =a.length;
        Arrays.sort(a);
        for(int i=0; i<n-3; i++){
            for(int j =i+1; j<n-2; j++){
                List<List<Integer>> curList = subArrayWithTwoSum(a,k-a[i]-a[j], j+1);

                for(List<Integer> list: curList){
                    List<Integer> tempAns =new ArrayList<>();
                    tempAns.add(a[i]);
                    tempAns.add(a[j]);
                    tempAns.addAll(list);
                    ans.add(tempAns);

                }
            }
        }
        return new ArrayList<>(ans);
     }




    static List<List<Integer>>  subArrayWithTwoSum(int []a, int k, int start){
         int l =start;
         int  r =a.length-1;
         List<List<Integer>> ans =new ArrayList<>();
         while(l<r){
             if(a[l] + a[r] == k){
                 List<Integer> list =new ArrayList<>();
                 list.add(a[l]);
                 list.add(a[r]);
                 ans.add(list);
                 l++;
                 r--;
             }else if( a[l] + a[r] > k){
                r--;
             }else {
                 l++;
             }
         }
        return ans;
    }

    static int countSubArrayWithGivenSum(int []a, int k){
        int cs =0;
        Set<Integer> set =new HashSet<>();
        int count =0;
        set.add(cs);
        for(int e: a){
            cs += e;
            if(set.contains(cs-k)){
                count++;
            }
                set.add(cs);

        }
        return count;

    }

    static int countSubArrayWithZeroSum(int[] a) {
        Set<Integer> set = new HashSet<>();
        int cs = 0;
        int count = 0;
        set.add(cs);
        for (int e : a) {
            cs += e;
            if (set.contains(cs)) {
                count++;
            } else {
                set.add(cs);
            }
        }

        return count;
    }
}
