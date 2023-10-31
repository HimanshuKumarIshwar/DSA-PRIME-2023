package binarySearching3;

public class MainClass {
    public static void main(String[] args) {
        int n =113488;
       System.out.println(sqr(n));


//        int []a ={2,3,4,10};
//        int [] b ={1,5,8,9};
//        System.out.println(medianOfTwoSortedArray(a,b));
    }
    static int sqr(int n){
        int l=1, r =n;
        int ans =-1;
        while(l<=r){
            int mid =l+(r-l)/2;
            if(mid==n/mid)return mid;
            if(mid< n/mid){
                ans =mid;
                l =mid+1;
            }else {
                r =mid-1;
            }
        }
        return ans;
    }

    static double medianOfTwoSortedArray(int []a, int []b){
        int n1 =a.length;
        int n2 =b.length;
        int n =n1+n2;
        int left =(n+1)/2;
        if(n1>n2)return medianOfTwoSortedArray(b,a);

        int l=0;
         int r =n1;
         while(l<=r){
             int m1 =l+(r-l)/2;
             int m2 =left-m1;

             int l1 = m1<=0 ? Integer.MIN_VALUE :a[m1-1];
             int l2 =m2<=0 ? Integer.MIN_VALUE : b[m2-1];
             int r1 =m1>=n1 ? Integer.MAX_VALUE : a[m1];
             int r2 =m2>+n2 ? Integer.MAX_VALUE : b[m2];

             if(l1<=r2 && l2<=r1){ // found median position
                 if(n%2==0){
                     return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2;
                 }else {
                     return Math.max(l1,l2);
                 }
             }
             if(l1>r2){
                 r =m1-1;
             }else if(l2>r1){
                 l =m1+1;
             }

         }




        return 0;

    }


}
