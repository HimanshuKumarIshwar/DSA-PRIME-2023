package collectionFrameWorkLive;

import java.util.*;

public class LearnComparableAndComparator {
    public static void main(String[] args) {
        Animal a1 = new Animal(4,10, "Lio");
        Animal a2 = new Animal(2,19, "Bruno");
        Animal a3 = new Animal(2,11, "Maxo");
        Animal a4  = new Animal(2,20, "Don");
        Animal a5 = new Animal(7,14, "Dask");
        Animal a6   = new Animal(9,20, "Lime");
        List<Animal> dogs =new ArrayList<>();
        dogs.add(a1);
        dogs.add(a2);
        dogs.add(a3);
        dogs.add(a4);
        dogs.add(a5);
        dogs.add(a6);

        System.out.println(dogs);


        //useing custom anyamous class
//      Collections.sort(dogs, new Comparator<Animal>() {
//          @Override
//          public int compare(Animal o1, Animal o2) {
//              return o1.weight-o2.weight;
//          }
//      });
//       dogs.sort((o1, o2)->o1.name.compareTo(o2.name));
//
//
//        System.out.println(dogs);




        int [][]a = {
            {4, 5, 2},
            {4, 1, 2},
            {1, 4, 7}
        };


        Arrays.sort(a, (arr1,arr2)->arr1[0]-arr2[0]);


        for(int[] arr: a){
            for(int e: arr){
                System.out.print(e+" ");
            }
            System.out.println();
        }

    }
}
