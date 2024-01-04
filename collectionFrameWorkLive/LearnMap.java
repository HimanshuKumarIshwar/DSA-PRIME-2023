package collectionFrameWorkLive;
import java.util.*;
public class LearnMap {
    public static void main(String[] args) {
       Map<String, String> map = new HashMap<>();
       map.put("Us", "United States");
       map.put("IN", "India");
       map.put("BZ", "Brazil");
        System.out.println(map);


        Set<Map.Entry<String, String>> enteries = map.entrySet();
        for(Map.Entry<String, String>entry: enteries){
            System.out.println(entry.getKey()+" -> "+ entry.getValue());
        }
    }
}
