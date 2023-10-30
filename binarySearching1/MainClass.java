package binarySearching1;

public class MainClass {
    public static void main(String[] args) {
//      int []a ={2,3,5,8,9,12,15};
//      int key =100;
//        System.out.println(binarySearchIter(a,key));
//        System.out.println(binarySerachRec(a,key,0,a.length-1));


        int a[] ={5,5,5,8,9,9,15,16};
        int key =5;
       System.out.println(firstOccurance(a,key));
        System.out.println(lastOccurance(a,key));
        System.out.println(countOccurance(a,key));

    }
    static int binarySearchIter(int []a,int key){
        int l=0; int r =a.length-1;
        while(l<=r){
            int mid =l+(r-l)/2;
            if(a[mid]==key)return mid;
            if(key<a[mid])r =mid-1;
            else if(key>a[mid])l =mid+1;
        }
       return -1;
    }
    static int binarySerachRec(int []a, int key,int l,int r){
        if(l>r)return -1;
        int mid =l+(r-l)/2;
        if(a[mid]==key)return mid;
        if(key<a[mid])return binarySerachRec(a,key,l,mid-1);
        return binarySerachRec(a,key,mid+1,r);
    }


    static int firstOccurance(int []a,int k){
        int l =0;
        int r =a.length-1;

        int ans =-1;
        while(l<=r){
            int mid =l+(r-l)/2;
            if(k<a[mid]){
                r=mid-1;
            }
            else if(k>a[mid]){
                l=mid+1;
            }
            else{
                ans =mid;
                r= mid-1;
            }
        }
        return ans;
    }

    static int lastOccurance(int []a, int k){
        int l =0;
        int r =a.length-1;
        int ans =-1;
        while(l<=r){
            int mid =l+(r-l)/2;
            if(k<a[mid])r=mid-1;
            else if(k>a[mid])l =mid+1;
            else{
                ans =mid;
                l =mid+1;
            }
        }
        return ans;
    }

    static int countOccurance(int a[],int k){
        int left =firstOccurance(a,k);
        if(left==-1)return 0;
        int right =lastOccurance(a,k);
        return right-left+1;
    }

}
