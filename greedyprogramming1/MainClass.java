package greedyprogramming1;

import java.util.Arrays;

public class MainClass {
    static class Item {
        int val,wt;

        public Item(int val,int wt) {
            this.val = val;
            this.wt =wt;
        }



    }
    public static void main(String[] args) {
        int[]a ={3,3,4,2,4,4,2,4,4};
      //  System.out.println(findMajorityElement(a));
        Item i1 =new Item(60,10);
        Item i2 =new Item(100,20);
        Item i3 =new Item(120,30);
        Item[] items ={i1,i2,i3};
        int capacity =50;

        System.out.println(fractionalKnapsack(items,capacity));
    }


    static double fractionalKnapsack(Item []items, int capacity){
        Arrays.sort(items, (o1, o2)-> {
              double ratioThis =(double)o1.val/o1.wt;
              double ratioThat = (double)o2.val/o2.wt;

              if(ratioThis>ratioThat)return -1;
              if(ratioThat>ratioThis)return 1;
              return 0;
        });


        double profit =0;
        for(int i=0; i<items.length; i++){
            if(items[i].wt<=capacity){
                profit+=items[i].val;
                capacity-=items[i].wt;
            }else{
                double fractionProfit = (double)(items[i].val*capacity)/items[i].wt;
                profit+=fractionProfit;
                break;
            }
        }
        return profit;
    }
    //moore's voting Algorithms
    static int findMajorityElement(int []a){
        int n =a.length;
        int count =1;
        int major =a[0];

        for(int i=1; i<n; i++){
            if(count==0){
                major =a[i];
                count=1;
            }
            if(a[i]==major)count++;
            else count--;
        }
        int freq=0;
        for (int j : a) {
            if (j == major) freq++;
        }



        return  freq>n/2 ? major:-1;




    }
}
