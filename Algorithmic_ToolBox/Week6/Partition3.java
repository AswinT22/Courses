package Courses.Algorithmic_ToolBox.Week6;

import java.util.*;
import java.io.*;

public class Partition3 {

    static int[] A;
    private static int partition3(int[] A) {
        //write your code here

        int n=A.length;
        if(n<3)
            return 0;

        long sum=0;

        for (int i = 0; i <n ; i++)
                sum+=A[i];

        if (sum%3!=0)
            return 0;

        int avg=(int)sum/3;


        if(knapSackWORep(avg,A))
            if(knapSackWORep(avg,A))
                return 1;

        return 0;
    }

    private static boolean knapSackWORep(int W,int[] A1){

        int n=A1.length;
         int[][]table=new int[n+1][W+1];


        for (int i = 1; i <=n ; i++) {

            for (int j = 1; j <=W ; j++) {


                if(j>=A1[i-1])
                    table[i][j]=Math.max(table[i-1][j],table[i-1][j-A1[i-1]]+A1[i-1]);
                else
                    table[i][j]=table[i-1][j-1];
            }


        }



        if (table[n][W]!=W)
            return false;


        List<Integer> array=new ArrayList<>();

        int temp=n;
        for (int i = 0; i <temp ; i++) {

        if(W<1)
            break;


        if (W==table[n-1][W])
            array.add(A1[n-1]);

        else
            W-=A1[n-1];

        --n;


        }
        A=new int[array.size()];

        for (int i = 0; i <A.length ; i++)
            A[i]=array.get(i);


        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
         A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

