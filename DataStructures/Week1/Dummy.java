package Courses.DataStructures.Week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Dummy {

    static Map<String,Integer> table=new HashMap<String,Integer>() ;


    public static void main(String[] args) {

        Random random= new Random();

        int n=10;

        double[]arr=new double[n];

        for (int i = 0; i <n; i++)
            arr[i]=((random.nextFloat()*(1000-1)+1));




        //
       // System.out.println(table.size());

       Arrays.sort(arr);
        for (double num:arr) {
            System.out.print(num+"  ");
        }


        System.out.printf("\n\n");
        long startTime = System.nanoTime();
        System.out.println(findMinWhile(arr));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

        long startTime1 = System.nanoTime();
        System.out.println(findMin(arr,arr.length-2,1,arr[arr.length-1]));
        long endTime1   = System.nanoTime();
        long totalTime1 = endTime1 - startTime1;
        System.out.println(totalTime1);


    }

    static  int findMinWhile(double[] arr){
        int n=arr.length;
        double minVal=arr[0];
        int min=1;
        int current=1;
        while(current<n){

            while (current<n && arr[current]-minVal<=1)
            {
                ++current;
            }

            if(current <n){
                ++min;
                minVal=arr[current];
            }


        }

        return min;

    }
    static int findMin(double[] arr,int index,int currentLength,double minVal)
    {
        Integer res=table.get(minVal+","+index);
        if(res!=null)
            return res;





        if(index<0){
            table.put(minVal+","+index,currentLength);
            return currentLength;
        }

        if(minVal-arr[index]<=1){
            int minLen=Math.min(findMin(arr,index-1,currentLength,minVal),findMin(arr,index-1,currentLength+1,arr[index]));
            table.put(minVal+","+index,minLen);
            return minLen;
        }

        else{

            int minLen=findMin(arr,index-1,currentLength+1,arr[index]);

            table.put(minVal+","+index,minLen);
            return minLen;
        }

    }
}
