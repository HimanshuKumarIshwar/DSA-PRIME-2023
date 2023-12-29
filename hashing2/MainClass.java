package hashing2;
import java.util.*;
public class MainClass {
    public static void main(String[] args) {
          int []a ={10,20,20,10,30,10};
        //System.out.println(countDistinctElement(a));
       // printFreqOfElement(a);
       // System.out.println(isTwoSum(a,70));
        int []ans =twoSumUsingMap(a,40);
        System.out.println(ans[0]+" "+ ans[1]);
    }

    static int[] twoSumUsingMap(int []a, int value){
        Map<Integer,Integer> map =new HashMap<>();
        int ans[] ={-1,-1};
        for(int i=0; i<a.length; i++){
            if(map.containsKey(value-a[i])){
               a[0] =  map.get(value-a[i]);
               a[i] =i;
               return ans;
            }else {
                map.putIfAbsent(a[i],i);
            }

        }
        return ans;
    }

    static boolean isTwoSum(int []a, int value){
        HashSet<Integer> set =new  HashSet<>();
        for(int e: a){
            if(set.contains(value-e)){
                return true;
            }
            set.add(e);

        }
        return false;
    }


    static void printFreqOfElement(int a[]){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int e: a){
            if(map.containsKey(e)){
                map.put(e, map.get(e)+1);
            }else {
                map.put(e,1);
            }
        }

        for(Map.Entry<Integer, Integer> entries: map.entrySet()){
            System.out.print(entries.getKey()+" -> "+ entries.getValue());
            System.out.println();
        }

    }
    static int countDistinctElement(int []a){
        HashSet<Integer> set  =new HashSet<>();
        for(int e: a){
            set.add(e);
        }
        return set.size();
    }
}
