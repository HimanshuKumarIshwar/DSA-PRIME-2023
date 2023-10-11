package queue2;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q=new LinkedList<>();

    public void push(int data){
        q.offer(data);
    }
    public int pop(){
        if(q.isEmpty())return -1;
        int size =q.size();
        for(int i=0; i<size-1; i++){
            q.offer(q.poll());
        }
        return q.poll();
    }

}
