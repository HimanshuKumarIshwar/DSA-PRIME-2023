package bitManupulationAndMathDoubt;

public class MainClass {
    public static void main(String[] args) {
       //int[]a ={12,1,12,3,12,1,1,2,3,3};
//       System.out.println(uniqueII(a));

//        int []a ={1,3,5};
//        System.out.println(differentBitSumPairsWise(a));

  int dnd =-10;
  int dsr =-3;
        System.out.println(divideInteger(dnd,dsr));
    }
    static int divideInteger(int dnd,int dsr){
        int sign = (dnd<0)^ (dsr<0) ? -1: 1;
     dnd =Math.abs(dnd);
     dsr =Math.abs(dsr);

   int ans =0;

   while(dnd>dsr){
       int i=0;
       int temp =dsr;
       while(dnd> (temp<<1)){

           temp =temp<<1;
           i++;
       }
       ans+=(1<<i);
       dnd =dnd-temp;
   }
   return ans*sign;



    }
    static int differentBitSumPairsWise(int []a ){
        int n =a.length;
        int ans =0;
        for(int i=0; i<32; i++){
            int k=0;
            for(int e: a){
                if((e & (1<<i)) !=0){
                    k++;
                }
            }
            ans+=(n-k)*k*2;
        }
        return ans;
    }


    static int uniqueII(int []a){
        int ans =0;
       for(int i=0; i<32; i++){
           int count =0;
           for(int e: a){
               if((e&(1<<i))!=0){
                   count++;
               }
           }
           if((count%3)!=0){
               ans =ans|(1<<i);
           }
       }
       return ans;
    }
}
