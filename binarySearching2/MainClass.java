package binarySearching2;

public class MainClass {
    public static void main(String[] args) {
//       int a[] ={2,3,5,8,9,12,15};
//       int k =3;
//        System.out.println(upperBound(a,k));
//        System.out.println(lowerBound(a,k));
        int a[] ={4,5,6,7,0,1,2};
        int k =4;
        System.out.println(sortedRotatedArray(a,k));
    }
    static int upperBound(int a[], int k){
        int  l=0;
        int r =a.length-1;
        int ans =a.length;
        while(l<=r){
            int mid =l+(r-l)/2;
            if(k<a[mid]){
                ans =mid;
                r =mid-1;
            }else if(k>=a[mid]){
                l =mid+1;
            }
        }
        return ans;
    }

    static int lowerBound(int a[],int k){
        int l =0;
        int r =a.length-1;
        int ans =-1;
        while(l<=r){
            int mid =l+(r-l)/2;
            if(k<=a[mid]){
                r= mid-1;
            }else if(k>a[mid]){
                ans =mid;
                l =mid+1;

            }
        }
        return ans;
    }

    static int sortedRotatedArray(int a[], int k){
        int l =0;
        int r =a.length-1;
        while(l<=r){
            int mid =l+(r-l)/2;
            if(a[mid]==k)return mid;
            if(a[l]==a[mid] && a[r] ==a[mid]){ // for duplicate element present
                l++;
                r--;
            }
            if(a[l]<=a[mid]){ //leftPart sorted
                if(k>=a[l] && k<a[mid]){
                    r= mid-1;
                }else{
                    l =mid+1;
                }
            }else{ //right part sorted
                if(k>a[mid] && k<=a[r]){
                    l =mid+1;
                }else{
                    r =mid-1;
                }

            }
        }
        return -1;
    }
}
