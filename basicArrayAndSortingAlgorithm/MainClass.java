package basicArrayAndSortingAlgorithm;

public class MainClass {
    public static void main(String[] args) {
//        int []a  ={1,2,3,5,6,7};
//        for(int e: a){
//            System.out.print(e+" ");
//        }
//        System.out.println();
//        int i=2;
//        int j = 4;
//        swap(a,i,j);
//        for(int e: a){
//            System.out.print(e+" ");
//        }


        int a[] ={2,0,12,7,8,9,5,-1};
       // bubbleSort(a);
       // selectionSort(a);
        insertionSort(a);
        for(int e: a){
            System.out.print(e+" ");
        }

    }
    //swaping two number in an array
    static void swap(int []a, int i, int j){
        int temp =a[i];
        a[i] =a[j];
        a[j]=temp;
    }


    //bubble sort

    static void bubbleSort(int []a){
        int n=a.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-1-i; j++){
                if(a[j]>a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
    }

    static void selectionSort(int []a){
        int n =a.length;
        for(int i=0; i<n-1; i++){
            int min =i;
            for(int j =i+1; j<n; j++){
                if(a[j]<a[min]){
                    min=j;
                }
            }
            swap(a,i,min);
        }
    }

    static void insertionSort(int []a){
        int n =a.length;
        for(int i=1; i<n; i++){
            int cur =a[i];
          int j=i-1;
          while(j>=0 && cur<a[j]) {
             a[j+1] =a[j];
             j--;
          }
          a[j+1] =cur;
        }
    }

}
