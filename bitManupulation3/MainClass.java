package bitManupulation3;

public class MainClass {
    public static void main(String[] args) {
       // int n=14;
        //System.out.println(clearTheLastSetBit(n));
        //System.out.println(countSetBitHack(n));

//        int []a= {2,4,7,9,2,4};
//        int []ans =findTwoUniqueNumber(a);
//        for(int e: ans){
//            System.out.println(e);
//        }

        int a[] ={1,3,4,8};
        int l=1;
        int r =2;
        System.out.println(xorQueries(a,l,r));






    }
    static int clearTheLastSetBit(int n){
        return n&(n-1);
    }
    static int countSetBit(int n){
        int count =0;
        while(n!=0){
            if((n&1)!=0){
                count++;
            }
            n= n>>1;
        }
        return count;
    }
    static int countSetBitHack(int n){
        int count =0;
        while(n!=0){
            n =n&(n-1);
            count++;
        }
        return count;
    }


    static int[] findTwoUniqueNumber(int []a){
        int xor =0;
        for(int e: a){
            xor =xor^e;
        }

        int mask =xor&(-xor);
        int firstNumber =0;
        for(int e: a){
            if((e&mask)!=0){
                firstNumber=firstNumber^e;
            }
        }
        int secondNumber =xor^firstNumber;
        int []ans =new int[2];
        ans[0] =firstNumber;
        ans[1] =secondNumber;
        return ans;
    }


    static int xorQueries(int []a, int l,int r){
        int []xor =new int[a.length];

        xor[0] =a[0];
        for(int i=1; i<a.length; i++){
            xor[i] =xor[i-1]^a[i];
        }

        int left =(l==0)?0:xor[l-1];
        int right =xor[r];
        return left^right;
    }
}
