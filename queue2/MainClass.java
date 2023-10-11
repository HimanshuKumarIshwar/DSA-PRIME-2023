package queue2;

public class MainClass {
    public static void main(String[] args) {

       StackUsingQueue stack =new StackUsingQueue();
       stack.push(12);
       stack.push(13);
        System.out.println(stack.pop());
        stack.push(15);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());



//        QueueUsingOneStack q=new QueueUsingOneStack();
//        q.enqueue(10);
//        q.enqueue(20);
//        q.enqueue(30);
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());


    }
}
