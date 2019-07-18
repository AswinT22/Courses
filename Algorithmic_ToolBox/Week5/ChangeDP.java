package com.Course.Algorithmic_Toolbox;

import java.util.Scanner;

public class ChangeDP {

    private static int getChange(int m,int[] table) {
        //write your code here
        if(m==0)
            return 0;
        if (m<0)
            return -1;

        if (table[m-1]!=0)
            return table[m-1];


        int x=getChange(m-4,table)+1;
        int y=getChange(m-3,table)+1;
        int z=getChange(m-1,table)+1;


        int min=0;


        min=findNonZeroMin(x,y);
        min=findNonZeroMin(min,z);

        min=min>0?min:-1;
        table[m-1]=min;
        return min;
    }

    private static int findNonZeroMin(int x, int y){

        if (x>0)
            if (y>0)
                return x<y?x:y;
            else
                return x;
        else
            if (y>0)
                return y;
            else
                return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] table=new int[m];

       int c=getChange(m,table);
       System.out.println(c<1?0:c);

    }
}

