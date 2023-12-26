package greedyprogramming2;
import java.sql.SQLOutput;
import java.util.*;
public class MainClass {
    static class Activity{
        int start,end;

        public Activity(int start,int end) {
            this.start = start;
            this.end=end;
        }
    }
    public static void main(String[] args) {
//int []st ={10,12,20};
//int [] finish ={20,25,30};
//        System.out.println(acitivitySelection(st,finish));

  int arr[] ={900,740,950,1100,1500,1800};
  int dep[] ={910, 1200,1120,1130,1900,2100};
        System.out.println(minimumPaltform(arr,dep));
    }

    static int minimumPaltform(int []arr,int dep[]){
        int n =arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=0;
        int j=0;
        int count =0;
        int maxCount =0;
        while(i<n){
            if(arr[i]<=dep[j]){
                count++;
                 maxCount =Math.max(maxCount,count);
                i++;
            }else{
                count--;
                j++;
            }
        }
        return maxCount;
    }
    static int acitivitySelection(int []s, int []f){
        int n =s.length;
        Activity [] activities =new Activity[n];

        for(int i=0; i<n; i++){
            activities[i] =new Activity(s[i],f[i]);
        }

        int count =1;
        int curFinish =activities[0].end;

        for(int i=1; i<n; i++){
            if(activities[i].start>=curFinish){
                count++;
                curFinish =activities[i].end;
            }
        }
        return count;

    }
}
