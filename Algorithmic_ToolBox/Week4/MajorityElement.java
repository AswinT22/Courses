package Courses.Algorithmic_ToolBox.Week4;

import java.util.*;
import java.io.*;

public class MajorityElement {


    static Random rand=new Random();
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }

        //write your code here

        quickSort(a,left,right);

        int num=a[0];
        int count=1;
        int n=a.length;
        int toWin=n/2;
        for (int i = 1; i <n ; i++) {

            if(num==a[i])
                ++count;

            else {
                count=1;
                num=a[i];
            }

            if (count>toWin)
                return 1;

        }


        //return count>toWin?1:-1;



        return -1;
    }


    public static void quickSort(int[] a,int left, int right)
    {

        while(left<right)
        {
//            int k=new Random().nextInt(right-left)+left;
//            swap(a,k,left);
            int[] m=partition(a,left,right);

            if(m[0]-left < right-m[1])
            {
                quickSort(a,left,m[0]);
                left=m[1];

            }
            else {


                quickSort(a,m[1],right);
                right=m[0];

            }



        }




    }

    private static int[] partition(int a[],int left,int right){


        int X=a[left],posPiv=left,j=left;

        for (int i = left+1; i < right; i++) {

            if(X> a[i])
            {
                ++j;
                swap(a,i,j);
            }
            else if (X==a[i]){
                ++j;
                ++posPiv;

                if (posPiv!=i){


                    swap(a,posPiv,i);
                if(posPiv!=j)
                    swap(a,i,j);
                }
            }
        }

        if(posPiv!=left)
        for (int k = 0; k < j-posPiv ; k++) {

            swap(a,left+k,posPiv+1+k);
        }
        else
            swap(a,left,j);

        return new int[]{j-(posPiv-left),j+1};

    }


    private static  void swap(int[]a, int pos1,int pos2){


        if(pos1!=pos2){

            int temp=a[pos1];
            a[pos1]=a[pos2];
            a[pos2]=temp;


        }

    }


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }



    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

