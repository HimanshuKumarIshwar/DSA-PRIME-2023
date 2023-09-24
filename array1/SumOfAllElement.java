package array1;

public class SumOfAllElement {
    public static void main(String[] args) {
        int []a = {3,4,5,7,8};
        int sum =0;
        for(int e: a){
            sum+=e;
        }
        System.out.println("Total sum is "+ sum);
    }
}
