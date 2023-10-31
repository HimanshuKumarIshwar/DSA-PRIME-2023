package binarySearching4;

public class MainClass {
    public static void main(String[] args) {
//     int []a ={1,7,6,3,4,7};
//     int k =8;
//        System.out.println(treeCutter(a,k));

        int []a ={1,2,4,8,9};
        int k =3;
        System.out.println(aggressiveCow(a,k));

    }
    static int treeCutter(int []a, int k){
        int l=0;
        int h = (int)1e9;
        while(l<=h){
            int mid = l+(h-l)/2;
            int totalWood = getWood(a,mid);
            if(totalWood== k)return mid;
            if(totalWood>k) l =mid+1;
            else h =mid-1;
        }
        return -1;
    }

    static int getWood(int []a, int cut){
        int ans =0;
        for(int e: a){
            ans+= e>cut ? e-cut: 0;
        }
        return ans;
    }

    static int aggressiveCow(int []a, int k){
        int l =0;
       int h =(int)1e9;
       int ans =-1;

       while(l<=h){
           int mid =l+(h-l)/2;
           if(isValid(a,k,mid)){
               ans =mid;
               l =mid+1;
           }else {
               h =mid-1;
           }
       }
       return ans;
    }
    static boolean isValid(int []a, int k, int des){
        int count =1;
       int prev =a[0];
        for(int i=1; i<a.length; i++){
            if(a[i]-prev>= des){
                count++;
                prev =a[i];
            }
        }
        return count>=k;
    }

}
