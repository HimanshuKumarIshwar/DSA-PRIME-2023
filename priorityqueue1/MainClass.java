package priorityqueue1;

public class MainClass {

    public static void main(String[] args) throws Exception {
    MaxHeap  mh = new MaxHeap(10);
    int []b = {5, 1, 8, 2, 3, 15};

    //mh.buildHeap(b);
      mh.heapSort(b);
      for(int e: b){
          System.out.print(e+" ");
      }


    }
}
