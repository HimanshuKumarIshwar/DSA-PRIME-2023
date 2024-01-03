package hashing4;
import java.util.*;
public class MainClass {
    public static void main(String[] args) {

        int []a ={1, 2, 1, 3, 4, 2, 3};
        int k = 4;
//        int []ans = uniqueElementInWindowsK(a,k);
//        for(int e: ans){
//            System.out.print(e+" ");
//        }
        String s ="abcabcbb";

        System.out.println(longestSubstringWithoutRepeat(s));

    }
    static int longestSubstringWithoutRepeat(String s){

Map<Character, Integer> map = new HashMap<>();
int l =0, r = 0;
int ans =0;
while(r<s.length()){
    if(!map.containsKey(s.charAt(r)) || map.get(s.charAt(r))<l){
        ans =Math.max(ans,r-l+1);

    }else {
        l =map.get(s.charAt(r))+1;
    }
    map.put(s.charAt(r), r);
    r++;

}
return ans;




    }
    static int[] uniqueElementInWindowsK(int []a, int k){
        int n = a.length;
        int [] ans = new int[n-k+1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++){
            if(map.containsKey(a[i])){
                map.put(a[i], map.get(a[i])+1);
            }else {
                map.put(a[i], 1);

            }

        }
        for(int i=k; i<n; i++){
            ans[i-k] =map.size();
            int left =i-k;
            int right =i;
            int freqLeft = map.get(a[left]);

            if(freqLeft == 1){
                map.remove(a[left]);
            } else {
                map.put(a[left],freqLeft-1);
            }


            if(map.containsKey(a[right])){
                map.put(a[right], map.get(a[right]+1));
            }else{
                map.put(a[right],1);
            }
        }

          ans[n-k] =map.size();



        return ans;
    }
}


