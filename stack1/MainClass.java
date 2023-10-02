package stack1;

public class MainClass {
    public static void main(String[] args) {
       // StackUsingArray stack =new StackUsingArray(4);
        StackUsingLinkedList stack =new StackUsingLinkedList();
        stack.push(1);
        stack.push(2);


        stack.push(4);
        stack.push(6);
        stack.peek();
        stack.push(7);
        System.out.println(stack.peek());
       // stack.printStack();
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }



    }
}
