package priorityqueue1;

import java.util.Collections;
import java.util.PriorityQueue;

public class LearnPriorityQueue {

    public static void main(String[] args) {
        // by default is minheap
        //PriorityQueue<Integer> pq = new PriorityQueue<>();
        // convert in to maxHeap
       // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //convert in to maxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);

        pq.add(20);
        pq.add(10);
        pq.add(30);
        pq.add(5);
        pq.add(50);
        pq.add(40);

        System.out.println(pq);
    }
}
