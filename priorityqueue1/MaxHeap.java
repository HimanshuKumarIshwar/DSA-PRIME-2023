package priorityqueue1;

public class MaxHeap {
    int []a;
    int capacity;
    int size;
    public MaxHeap(int capacity){
        this.capacity = capacity;
        a = new int[capacity];
        size =0;
    }

    public boolean insert(int e){
        if(size == capacity)return false;
        a[size] = e;
        int i = size;
        while(i>0){
            int parent = (i-1)/2;
            if(a[parent]<a[i]){
                swap(i,parent);
               i = parent;
            }else break;
        }
        size++;
        return true;
    }


    public  int pop() throws Exception{
        if(size == 0)  throw new Exception("Empty pyq");
        size--;
        int temp = a[0];
        a[0] = a[size];
        heapify(0);
       return temp;
    }

    public  void heapify(int i){
        if(i >=size)return;
        int left = i*2+1;
        int right = i*2 + 2;
        int larger =i;
        if( left < size && a[left] > a[right]){
            larger = left;

        }
        if( right < size && a[right]> a[larger]){
            larger = right;
        }

        if(larger !=i){
            swap(larger, i);
            heapify(larger);
        }
    }


   public void swap(int i, int j){
        int temp =a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void print(){
        for(int i=0; i<size; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


    public void buildHeap(int []b){
        if(b.length> capacity)return;

        for(int i = 0; i <b.length; i++){
              a[i] = b[i];
        }
        size = b.length;
        for(int i =size-1; i>=0; i--){
            heapify(i);
        }

        for(int i = 0; i <b.length; i++){
            b[i] = a[i];
        }

    }


    public void heapSort(int b[]) throws Exception{
        buildHeap(b);

       for(int i = b.length-1; i>=0; i--){
           b[i] = pop();
       }
    }

}
