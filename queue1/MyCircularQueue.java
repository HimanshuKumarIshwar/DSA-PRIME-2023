package queue1;

public class MyCircularQueue {
   int size;
   int []a;
   int rear,front;
   public MyCircularQueue(int size){
       this.size =size;
       rear=front=-1;

   }

   public boolean isEmpty(){
       return front==-1;
   }
   public boolean isFull(){
      if(front==0 &&  rear==size-1) return true;
      return front+1==rear;
   }
   public boolean enqueue(int data){
       if(isFull()){
           System.out.println("Queue is full cannot add data");
           return false;
       }

      if(isEmpty()){
          front=0;
      }
      rear =(rear+1)%size;
      a[rear] =data;
      return true;


   }
   public int dequeue(){
       if(isEmpty()){
           System.out.println("queue is Empty cannot perform dequeue");
           return -1;
       }

       int temp =a[front];

       if(front==rear){
           front=rear=-1;
           return temp;
       }
       front =(front+1)%size;
       return temp;
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
        if(rear>=front){
            for(int i=front; i<=rear; i++){
                System.out.print(a[i]+" ");
            }
        }else{
            for(int i=0; i<size; i++){
                System.out.print(a[i]+" ");
            }
            for(int i=0; i<=rear; i++){
                System.out.print(a[i]+" ");
            }
        }
        System.out.println();
    }



}
