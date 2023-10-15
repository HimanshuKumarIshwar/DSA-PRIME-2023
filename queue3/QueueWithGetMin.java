package queue3;
import java.util.*;
public class QueueWithGetMin {
    Queue<Integer> q =new LinkedList<>();
    ArrayDeque<Integer> dq =new ArrayDeque<>();


      public void enqueue(int data){
          q.offer(data);
          while(!dq.isEmpty() && dq.getLast()>data){
              dq.pollLast();
          }
          dq.offerLast(data);
      }
      public int dequeue(){
          if(q.isEmpty())return -1;
          int temp =q.poll();
          if(temp==dq.getLast()){
              dq.pollFirst();
          }
          return temp;
      }
      public  int getMin(){
          return dq.getFirst();
      }

}
