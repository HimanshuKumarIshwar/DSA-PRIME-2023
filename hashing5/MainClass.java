package hashing5;
import java.util.*;
public class MainClass {
    public static void main(String[] args) {
//        int [][]a = {{2, 2, 2, 2},
//                     {2, 2, 2, 2,},
//                      {2, 2, 2, 2},
//                       {2, 2, 2, 2}
//        };
//        int target = 8;
//        System.out.println(countMatricesWithGivenSum(a, target));

//int [] a ={15, -2, 2, -8, 1, 7, 10, 13};
//        System.out.println(largestSubArrayZeroSum(a));


        String [] strings ={"cat", "dog", "god", "tca"};
        ArrayList<ArrayList<Integer>> ans = angramString(strings);
        System.out.println(ans);

    }


    static class Anagram{
        int []freq;
        public Anagram(String s) {
            freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }
        }
            public int hashCode(){
                return Arrays.hashCode(freq);
            }
            public boolean equals(Object o){
                Anagram that = (Anagram)o;
                return Arrays.equals(this.freq, that.freq);

            }



    }

    static ArrayList<ArrayList<Integer>> angramString(String strings[]){
        Map<Anagram, ArrayList<Integer>> map =new HashMap<>();
        for(int i =0; i<strings.length; i++){
            String s =strings[i];
            Anagram anagram  = new Anagram(s);
            if(!map.containsKey(anagram)){
                map.put(anagram, new ArrayList<>());
            }
            map.get(anagram).add(i+1);



        }

        return new ArrayList<>(map.values());
    }

    static int largestSubArrayZeroSum(int []a){
        Map<Integer, Integer> map =new HashMap<>();
        map.put(0,-1);
        int cs =0;
        int maxLength = 0;
        for(int i = 0; i < a.length; i ++){
            cs += a[i];
            if(map.containsKey(cs)){
                int length  = i-map.get(cs);
                maxLength = Math.max(maxLength, length);
            }else {
                map.put(cs, i);
            }
        }
        return maxLength;

    }
    static int countMatricesWithGivenSum(int [][]m, int target){
          int row =m.length;
          int col =m[0].length;

          // preProcessing

        for(int i=0; i<row; i++){
            for(int j=1; j<col; j++){
                m[i][j] += m[i][j-1];
            }
        }


        Map<Integer, Integer> map =new HashMap<>();
        int ans = 0;
        for(int i = 0; i < col; i++){
            for(int j = i; j < col; j++){
                map.clear();
               map.put(0, 1);
                int sum =0;
                for(int k =0; k<row; k++){
                     sum+= (m[k][j] - (i > 0 ? m[k][i-1] : 0));

                   int  freq =  map.getOrDefault(sum-target,0);
                   ans += freq;
                    map.put(sum,map.getOrDefault(sum,0) +1);
                }


            }
        }



        return ans;
    }
}
