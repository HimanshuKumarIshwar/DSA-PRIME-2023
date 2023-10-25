package matheMatics1;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
       // System.out.println(isPrime(8));

//        int n=100;
//        boolean []isPrime =sieveOfEratosthenes(n);
//        for(int i=0;i<=n; i++){
//            if(isPrime[i]){
//                System.out.println(i);
//            }
//        }
//        System.out.println("end");


        int a =36;
        int b =12;
        System.out.println(gcd(a,b));
    }
    static boolean isPrime(int n){
        for(int i=2; i*i<=n; i++){
            if(n%i==0)return false;
        }
        return true;
    }
    static boolean[] sieveOfEratosthenes(int n){
        boolean[] isPrime =new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1] =false;

        for(int i=2; i*i<=n; i++){
            for(int j=i*i; j<=n; j+=i){
                isPrime[j] =false;
            }
        }
        return isPrime;
    }

    static int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }

}
