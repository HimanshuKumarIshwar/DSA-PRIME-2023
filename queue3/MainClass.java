package queue3;
import java.util.*;


public class MainClass {
    public static void main(String[] args) {
//  String s ="aabcdbcbbd";
//
//       System.out.println(firstNonRepeatingStream(s));



      QueueWithGetMin q =new QueueWithGetMin();
      q.enqueue(5);
      q.enqueue(1);
        System.out.println(q.getMin());


    }
    static String firstNonRepeatingStream(String s){
        int[] freq =new int[26];
        StringBuilder sb =new StringBuilder();
        Queue<Character> q =new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char c =s.charAt(i);
            q.offer(c);
            freq[c-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                  q.poll();
                  
            }
            if(q.isEmpty()){
                sb.append('#');
            }else{
                sb.append(q.peek());
            }
        }
return sb.toString();

    }


}
