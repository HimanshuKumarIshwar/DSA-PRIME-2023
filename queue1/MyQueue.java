package queue1;

public class MyQueue {
    int size;
    int rear,front;
   private int []a;
    public MyQueue(int size){
        this.size =size;
        a= new int[size];
        front=rear=-1;
    }

   public boolean isEmpty(){
        return front==-1;
   }
   public boolean isFull(){
        return rear==size-1;
   }

   public boolean enqueue(int data){
        if(isFull()){
            System.out.println("Queue is full cannot add new element");
            return false;
        }
        if(isEmpty()){
          front=0;

        }
        rear++;
        a[rear] =data;
        return true;
   }

   public int dequeue(){
        if(isEmpty()){
            System.out.println("queue is Empty cannot dequeue");
            return -1;
        }
        int data =a[front];
        if(front==rear){
            front=rear=-1;
            return data;
        }
        front++;
        return data;
   }
   public int peek(){
       if(isEmpty()){
           System.out.println("queue is Empty cannot dequeue");
           return -1;
       }
       return a[front];
   }
   public void printQueue(){
        if(isEmpty())return;
        for(int i=front; i<=rear; i++){
           System.out.print(a[i]+" ");
       }
       System.out.println();
   }


}
