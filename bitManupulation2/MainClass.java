package bitManupulation2;

public class MainClass {
    public static void main(String[] args) {
//       int n =13;
//       int i=2;
        //System.out.println(getIThBit(n,i));
        //System.out.println(setTheIthBit(n,i));
      //  System.out.println(clearIthBit(n,i));
        int n=742;
        int i=1;
        int j =3;
        System.out.println(clearBitInRange(n,i,j));
    }
    static int getIThBit(int n, int i){
        int mask = (1<<i);
//        if((n&mask)==0){
//            return 0;
//        }
//        return 1;


        return (n&mask)==0 ?0:1;
    }

    static int setTheIthBit(int n, int i){
        int mask = (1<<i);
        return n|mask;
    }

static int clearIthBit(int n, int i){
        int mask = ~(1<<i);
         return n&mask;
}
static int clearBitInRange(int n,int i,int j){
        int a =(~0<<(j+1));
        int b =(1<<i)-1;
        int mask= a|b;
        return n&mask;

}



}
