package Courses.Algorithmic_ToolBox.Week4;

import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a,  int left, int right) {
//        long numberOfInversions = 0;
//        if (right <= left + 1) {
//            return numberOfInversions;
//        }
//        int ave = (left + right) / 2;
       // numberOfInversions += getNumberOfInversions(a, b, left, ave);
       // numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        return sortArray(a,left,right);
    }


    private static int sortArray(int[] a,int left,int right){

        if (right-left< 2)
            return 0;


        int mid=left+((right-left)/2);

        int b=sortArray(a,left,mid);
        int c=sortArray(a,mid,right);
        int splitInversion=merge(a,left,right,mid);

        return b+c+splitInversion;
    }


    private static int merge(int[] a,int left,int right,int mid ){

        int[] L1=Arrays.copyOfRange(a,left,mid);
        int[] L2=Arrays.copyOfRange(a,mid,right);
        int n1=L1.length,i=0;
        int n2=L2.length,j=0;
        int k=left,counter=0;
        while (i<n1 && j<n2)
        {
            if(L1[i]<=L2[j]) {
                a[k] = L1[i];
                ++i;
            }

            else {

                counter+=n1-i;
                a[k]=L2[j];
                ++j;

            }

            ++k;

        }

        while (i<n1){
            a[k] = L1[i];
            ++i;
            ++k;
        }

        while (j<n2){
            a[k]=L2[j];
            ++j;
            ++k;
        }

        return counter;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
       // int[] b = new int[n];
        System.out.println(getNumberOfInversions(a,  0, a.length));
    }
}

